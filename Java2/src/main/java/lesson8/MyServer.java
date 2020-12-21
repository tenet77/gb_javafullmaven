package lesson8;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MyServer implements Runnable {

    private final int PORT = 8189;
    private final ConcurrentLinkedDeque<ClientHandler> clients;

    public MyServer() {
        this.clients = new ConcurrentLinkedDeque<>();
    }

    private synchronized void addClient(ClientHandler client) {
        clients.add(client);
    }

    public synchronized void removeClient(ClientHandler client) {
        if (clients.contains(client)) {
            clients.remove(client);
        }
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                System.out.println("Server wait connection");
                Socket socket = server.accept();
                System.out.println("Connection accepted");
                ClientHandler client = new ClientHandler(this, socket);
                addClient(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadCast(String msg, String clientName) throws IOException {
        for (ClientHandler client : clients) {
            if (client.isAuthOk() && clientName.equals("") || client.isAuthOk() && Objects.equals(clientName, client.getClientName()))
            {
                client.sendMessage(msg);
            }
        }
    }
}
