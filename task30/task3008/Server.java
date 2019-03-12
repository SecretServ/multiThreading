package com.javarush.task.task30.task3008;

import com.javarush.task.task30.task3008.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static com.javarush.task.task30.task3008.ConsoleHelper.writeMessage;

public class Server {

    public static void main(String[] args) {
        try {
            int port = ConsoleHelper.readInt();
            ServerSocket ss;
            ss = new ServerSocket(port);
            System.out.println("Cервер запущен");
            try {
                while (true) {
                    Socket socket = ss.accept();
                    Handler handler = new Handler(socket);
                    handler.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
                ss.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Client client = new Client();
        client.run();
        client.notify();
    }


    private static class Handler extends Thread {

        public Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public String name;

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while(true) {

                connection.send(new Message(MessageType.NAME_REQUEST, "Enter your name please"));
                Message answer = connection.receive();
                String ans = answer.getData();
                if (answer.getType().equals(MessageType.USER_NAME)) {
                    if (!ans.isEmpty()){
                        if (!connectionMap.containsKey(ans)) {
                            connectionMap.put(ans, connection);
                            name = ans;
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return name;
                        }
                    }
                }
            }//While Cycle End
        }//serverHandShakeEnd

        private void notifyUsers(Connection connection, String userName) throws IOException {
            Set<Map.Entry<String, Connection>> set = connectionMap.entrySet();
            for(Map.Entry<String, Connection> s : set){
                if (!s.getKey().equals(userName)) {
                    s.getValue().send(new Message(MessageType.USER_ADDED, userName));
                    connection.send(new Message(MessageType.USER_ADDED, s.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while(true) {
                Message answer = connection.receive();
                if (answer.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + answer.getData()));
                } else {
                    writeMessage("Error occured");
                    //break;
                }
            }
        }

        public void run() {

            try {
                writeMessage("Соединение с удаленным адресом: " + socket.getRemoteSocketAddress() + " установлено");
                Connection connection = new Connection(socket);
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                if (!userName.isEmpty()) {
                    Set<Map.Entry<String, Connection>> set = connectionMap.entrySet();
                    for(Map.Entry<String, Connection> s : set){
                        if (s.getKey().equals(userName)) {
                            connectionMap.remove(s.getKey(), s.getValue());
                            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                            connection.close();
                        }
                    }
                }
            } catch (Exception e) {
                writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            } finally {
                writeMessage("Соединение с удаленным сервером закрыто");
            }
        }//end of RUN method

    } //Handler CLASS end

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    public static void sendBroadcastMessage(Message message) {
        try {
            Set<Map.Entry<String, Connection>> set = connectionMap.entrySet();
            for(Map.Entry<String, Connection> s : set){
                s.getValue().send(message);
            }
        } catch (IOException e) {
            System.out.println("Сообщение не отправлено");
        }
    }

}
