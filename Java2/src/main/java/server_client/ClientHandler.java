package server_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ClientHandler implements Runnable {

    private final MyServer server;
    private final Socket socket;
    private DataInputStream is;
    private DataOutputStream os;
    private String clientName;
    private boolean authOk;

    public ClientHandler(MyServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
        this.authOk = false;
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
            String msg = "";
            String cmd = "";
            while (true) {
                try {
                    cmd = is.readUTF();
                    msg = is.readUTF();
                } catch (Exception e) {
                    System.out.println("Client crashed");
                    server.removeClient(this);
                    break;
                }
                System.out.println("Message from " + clientName + ": /" + cmd + " " + msg);
                handleMessage(cmd, msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleMessage(String cmd, String msg) throws IOException {
        String[] cmdArr = cmd.split(" ");
        if (cmdArr[0].equals("/login")) {
            clientName = msg;
            authOk = true;
            server.broadCast("Login ok", clientName);
            server.broadCast(clientName + " is here ", "");
        } else if (cmdArr[0].equals("/logout")) {
            server.broadCast("Logout ok", clientName);
            authOk = false;
            server.broadCast(clientName + " leave us", "");
        } else if (cmdArr[0].equals("/message")) {
            if (cmdArr.length > 1) {
                server.broadCast(msg, cmdArr[1]);
            } else {
                server.broadCast(msg, "");
            }
        }
    }

}
