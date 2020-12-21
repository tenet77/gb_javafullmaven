package lesson7;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    public TextArea mainTextArea;
    public TextField messageField;
    private ClientHandler client;
    private DataInputStream is;
    private DataOutputStream os;

    public void menuNew() {
        mainTextArea.clear();
    }

    public void menuQuit() throws IOException {
        client.close();
        System.exit(0);
    }

    public void btnSendClickAction() throws IOException {
        showMessage("Client :" + messageField.getText());
        sendMessage(messageField.getText());
        messageField.clear();
        messageField.requestFocus();
    }

    public void showMessage(String message) {
        mainTextArea.appendText(message + "\n");
    }

    public void sendMessage(String message) throws IOException {
        os.writeUTF(message);
        os.flush();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Socket socket = new Socket("localhost", 8189);
            is = new DataInputStream(socket.getInputStream());
            os = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
