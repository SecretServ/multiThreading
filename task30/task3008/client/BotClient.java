package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        //return String.format("date_bot_%2d", (int) (Math.random() * 100));
        return "date_bot_" + (int)(Math.random()*100);
    }


    /************************************************************************/
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, " +
                    "месяц, год, время, час, минуты, секунды.");

            try {
                super.clientMainLoop();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(":")) {
                String[] strings = message.split(": ");
                String userName = strings[0];
                String text = strings[1];
                SimpleDateFormat simpleDateFormat;
                switch (text) {
                    case "дата":
                        simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        simpleDateFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        simpleDateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        simpleDateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        simpleDateFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        simpleDateFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        simpleDateFormat = new SimpleDateFormat("s");
                        break;
                    default:
                        simpleDateFormat = null;
                        break;
                }

                if (simpleDateFormat != null) {
                    Calendar calendar = Calendar.getInstance();
                    String result = "Информация для " + userName + ": ";
                    result += simpleDateFormat.format(calendar.getTime());
                    sendTextMessage(result);
                }


            }
        }

    }
    /************************************************************************/

}
