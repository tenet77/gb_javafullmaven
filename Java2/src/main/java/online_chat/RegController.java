package online_chat;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegController {
    public TextField login;
    public PasswordField password;
    public Label info;

    public void registration(ActionEvent actionEvent) throws IOException {
        AuthService.getInstance().add(login.getText(), password.getText());
        FormService.showForm("auth",
                "Login",
                (Stage) login.getScene().getWindow());
    }
}
