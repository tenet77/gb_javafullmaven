package lesson8;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.stage.WindowEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    public javafx.scene.control.TextArea TextArea;
    public javafx.scene.control.TextField TextField;
    private DataInputStream is;
    private DataOutputStream os;
    private boolean running;
    private Thread readThread;

    private final EventHandler<WindowEvent> closeEventHandler = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            running = false;
            readThread.interrupt();
        }
    };

    public void sendMessage() {
        String msg = TextField.getText();
        TextField.clear();
        try {
            os.writeUTF(msg);
            os.flush();
        } catch (Exception e) {
            TextArea.appendText("Server not connected \n");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        running = true;
        TextArea.appendText("Type /login <nickname>, for login \n");
        TextField.requestFocus();
        try {
            Socket socket = new Socket("localhost", 8189);
            is = new DataInputStream(socket.getInputStream());
            os = new DataOutputStream(socket.getOutputStream());
            readMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readMessage() {

        readThread = new Thread(() -> {
            while (running) {
                try {
                    String msg = is.readUTF();
                    TextArea.appendText(msg + "\n");
                } catch (IOException e) {
                    System.out.println("Error");
                    break;
                }
            }
        });
        readThread.setDaemon(true);
        readThread.start();
    }

    public EventHandler<WindowEvent> getCloseEventHandler() {
        return closeEventHandler;
    }
}
