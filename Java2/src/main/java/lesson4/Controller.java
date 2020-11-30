package lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    TextArea mainTextArea;
    @FXML
    TextField messageField;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public void sendMessage() {
        String message = messageField.getText();
        if (!message.equals("")) {
            mainTextArea.appendText(String.format("%s : %s \n",
                    dtf.format(LocalDateTime.now()), messageField.getText()));
            messageField.setText("");
        }
        messageField.requestFocus();
    }

    public void btnSendClickAction(ActionEvent actionEvent) {
        sendMessage();
    }

    public void menuNew(ActionEvent actionEvent) {
        mainTextArea.setText("");
    }

    public void menuQuit(ActionEvent actionEvent) {
        System.exit(0);
    }
}