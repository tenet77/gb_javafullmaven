package online_chat;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    public TextArea mainTextArea;
    public TextField messageField;

    public void menuNew() {
        mainTextArea.clear();
    }

    public void menuQuit() {
        System.exit(0);
    }

    public void btnSendClickAction() {
        mainTextArea.appendText(messageField.getText() + "\n");
        messageField.clear();
        messageField.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
