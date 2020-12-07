package online_chat;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthController {
    public TextField login;
    public PasswordField password;
    public Label info;

    public void login(ActionEvent actionEvent) throws IOException {
        if (AuthService.getInstance().auth(login.getText(), password.getText())) {
            FormService.showForm("messenger",
                    "Online messenger",
                    (Stage) login.getScene().getWindow());
        } else {
            login.clear();
            password.clear();
            info.setText("Wrong login or password");
            login.requestFocus();
        }
    }

    public void registration(ActionEvent actionEvent) throws IOException {
        FormService.showForm("reg",
                "Register",
                (Stage) login.getScene().getWindow());

    }
}
