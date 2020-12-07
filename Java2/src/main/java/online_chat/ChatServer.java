package online_chat;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server started and wait connection");
            Socket socket = serverSocket.accept();
            System.out.println("Server connection accepted");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutput out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String s = in.readUTF();
                if (s.equals("/end")) {
                    break;
                }
                out.writeUTF("Server : " + s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
