package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

public class ClientGuiController extends Client {

    private ClientGuiModel model = new ClientGuiModel();
    private static ClientGuiController contra;
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args) {
        contra = new ClientGuiController();
        contra.run();
    }

    public class GuiSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }
        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }
        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }
        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        GuiSocketThread gst = new GuiSocketThread();
        return gst;
    }
    @Override
    public void run() {
        getSocketThread().run();
    }
    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }
    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }
    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    public ClientGuiModel getModel() {
        return model;
    }

}
