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

            while(true) {

                connection.send(new Message(MessageType.NAME_REQUEST, "qwerty"));
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

    } //Handler end




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
