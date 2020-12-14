package server_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8189);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        new Thread(()->{
            while (true) {
                String msg = scanner.nextLine();
                try {
                    out.writeUTF(msg);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(()->{
            while (true) {
                try {
                    String msg = in.readUTF();
                    System.out.println("From server: " + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
