package lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MsgServer {

    private final int PORT = 8189;
    private boolean running;
    private ConcurrentLinkedDeque<ClientHandler> clients = new ConcurrentLinkedDeque<>();
    private MsgServer instance;

    private MsgServer getInstance() {
        if (instance == null) {
            instance = new MsgServer();
        }

        return instance;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public MsgServer() {
        running = true;
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started");
            while (running) {
                Socket socket = server.accept();
                ClientHandler handler = new ClientHandler(socket, this);
                clients.add(handler);
                new Thread(handler).start();
            }
        } catch (Exception e){
            System.out.println("Server crashed");
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public void broadCast(String msg) throws IOException {
        for (ClientHandler client : clients) {
            client.sendMessage(msg);
        }
    }

}
