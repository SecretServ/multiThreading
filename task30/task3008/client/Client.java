package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Возникло исключение ввода-вывода");
            clientConnected = false;
        }
    }

    /****************************** inner class class SocketThread START ******************************************/

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Пользователь " + userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Пользователь " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }


        protected void clientHandshake() throws IOException, ClassNotFoundException {

            while (true) {
                MessageType answer = connection.receive().getType();
                if(answer == MessageType.NAME_REQUEST) {
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                } else if (answer == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }//end of clientHandshake METHOD

        
        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            while(true) {
                Message answerMessage = connection.receive();
                MessageType type = answerMessage.getType();
                if (type == MessageType.TEXT) {
                    processIncomingMessage(answerMessage.getData());
                } else if (type == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(answerMessage.getData());
                } else if (type == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(answerMessage.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }//end of clientMainLoop METHOD


        public void run() {

            String adress = getServerAddress();
            int port = getServerPort();

            try {
                Socket socket = new Socket(adress, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (UnknownHostException e) {
                e.printStackTrace();
                notifyConnectionStatusChanged(false);
            } catch (IOException f) {
                f.printStackTrace();
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException g) {
                g.printStackTrace();
                notifyConnectionStatusChanged(false);
            }





        }

    } //SocketThread CLASS end

    /***************************** inner class class SocketThread FINISH ********************************/



    public void run() {

        SocketThread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("В работе прошраммы возникло исключение");
                thread.interrupt();
            }

            if (clientConnected) {
                /*synchronized (this) {
                    notify();
                }*/
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }

            while (clientConnected) {
                String command = ConsoleHelper.readString();
                if (command.equals("exit")) {
                    break;
                } else {
                    if (shouldSendTextFromConsole()) {
                        sendTextMessage(command);
                    }
                }
            }
        }
    }
}
