package lesson8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final MyServer server;
    private final Socket socket;
    private DataInputStream is;
    private DataOutputStream os;
    private String clientName;
    private boolean authOk;
    private boolean running;

    public ClientHandler(MyServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
        this.authOk = false;
        this.running = true;
    }

    public void sendMessage(String msg) throws IOException {
        os.writeUTF(msg);
        os.flush();
    }

    public String getClientName() {
        return clientName;
    }

    public boolean isAuthOk() {
        return authOk;
    }

    @Override
    public void run() {
        try {
            is = new DataInputStream(socket.getInputStream());
            os = new DataOutputStream(socket.getOutputStream());
            String msg;
            waitAuth();
            while (running) {
                try {
                    msg = is.readUTF();
                } catch (Exception e) {
                    System.out.println(clientName + ": client crashed");
                    server.removeClient(this);
                    break;
                }
                System.out.println("Message from " + clientName + ": " + " " + msg);
                handleMessage(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void waitAuth() {

        Thread wait = new Thread(() -> {
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!authOk) {
                running = false;
            }
        });
        wait.start();
    }

    private void handleMessage(String msg) throws IOException {
        String[] cmdArr = msg.split(" ");
        if (cmdArr[0].equals("/login")) {
            clientName = cmdArr[1];
            authOk = true;
            server.broadCast("Login ok", clientName);
            server.broadCast(clientName + " is here ", "");
        } else if (cmdArr[0].equals("/logout")) {
            server.broadCast("Logout ok", clientName);
            authOk = false;
            server.broadCast(clientName + " leave us", "");
        } else if (cmdArr[0].equals("/w")) {
            if (cmdArr.length > 1) {
                server.broadCast(clientName + ": " + cmdArr[2], cmdArr[1]);
            }
        } else {
            server.broadCast(clientName + ": " + cmdArr[0], "");
        }
    }
}
