package online_chat;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    public TextArea mainTextArea;
    public TextField messageField;
    private ClientService client;

    public void menuNew() {
        mainTextArea.clear();
    }

    public void menuQuit() {
        client.closeConnection();
        System.exit(0);
    }

    public void btnSendClickAction() {
        showMessage("Client :" + messageField.getText());
        sendMessage(messageField.getText());
        messageField.clear();
        messageField.requestFocus();
    }

    public void showMessage(String message) {
        mainTextArea.appendText(message + "\n");
    }

    public void sendMessage(String message) {
        client.sendMessage(message);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        client = new ClientService(this);
        new Thread(client).start();
    }
}
