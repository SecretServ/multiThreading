package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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
    }


    private static class Handler extends Thread {

        public Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public String name;

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            //Message message = connection.send();
            while(true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "qwerty"));
                Message answer = connection.receive();
                if (answer.getType().equals(MessageType.USER_NAME)) {
                    if (!answer.getData().isEmpty()){
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            this.name = answer.getData();
                            connection.send(new Message(MessageType.NAME_ACCEPTED));

                        }
                    } else {
                        //connection.send(new Message(MessageType.NAME_REQUEST));
                        break;
                    }
                } else {
                    break;
                }
                //return name;
            }


            /*String name = null;
            while(true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                if (connection.receive().getType() != MessageType.USER_NAME) {
                    break;
                } else {
                    name = connection.receive().getData();
                    Set<Map.Entry<String, Connection>> set = connectionMap.entrySet();
                    for(Map.Entry<String, Connection> s : set){
                        if (name.isEmpty() || !s.getKey().equals(name)) {
                            connectionMap.put(name, connection);
                            return name;
                        } else {
                            connection.send(new Message(MessageType.NAME_REQUEST));
                            break;
                        }
                    }

                }
                //return name;
            }
            return name;*/

            return name;

        }



    }




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
