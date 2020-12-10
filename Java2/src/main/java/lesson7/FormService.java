package lesson7;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FormService {

    public static Stage showForm(String formName, String title) throws IOException {
        Parent chat = FXMLLoader.load(FormService.class.getResource(formName + ".fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(chat));
        primaryStage.show();

        return primaryStage;
    }

    public static Stage showForm(String formName, String title, Stage fromStage) throws IOException {
        fromStage.close();
        return showForm(formName, title);
    }
}
