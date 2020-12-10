package online_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientService implements Runnable{

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private final ChatController chatController;

    public ClientService(ChatController chatController) {
        this.chatController = chatController;
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        socket = null;
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                if (!socket.isClosed()) {
                    String sFromServer = in.readUTF();
                    chatController.showMessage(sFromServer);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
