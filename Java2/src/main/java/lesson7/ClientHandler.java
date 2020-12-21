package lesson7;


import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable, Closeable {

    private static int cnt = 0;
    private final String userName;
    private final DataInputStream is;
    private final DataOutputStream os;
    private boolean running;
    private final byte[] buffer;
    private final MsgServer server;

    public ClientHandler(Socket socket, MsgServer server) throws IOException {
        is = new DataInputStream(socket.getInputStream());
        os = new DataOutputStream(socket.getOutputStream());
        cnt++;
        userName = "user#" + cnt;
        running = true;
        buffer = new byte[256];
        this.server = server;
    }

    @Override
    public void close() throws IOException {
        while (running) {
            try {
                int bytesRead = is.read(buffer);
                if (bytesRead == -1) {
                    server.removeClient(this);
                    break;
                }
                String msg = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                System.out.println("Received from " + userName + " : " + msg);
                server.broadCast(userName+":" + msg);
            } catch (IOException e) {
                System.err.println("Exception while read");
                break;
            }
        }
    }

    public void sendMessage(String message) throws IOException {
        os.write(message.getBytes(StandardCharsets.UTF_8));
        os.flush();
    }

    public String getUserName() {
        return userName;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {

    }
}
