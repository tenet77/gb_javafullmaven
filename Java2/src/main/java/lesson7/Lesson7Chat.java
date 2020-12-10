package lesson7;

import javafx.application.Application;
import javafx.stage.Stage;

public class Lesson7Chat extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = FormService.showForm("auth", "Login");
    }

    public static void main(String[] args) {
        MsgServer chatServer = new MsgServer();
        launch(args);
    }
}
