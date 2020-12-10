package online_chat;

import javafx.application.Application;
import javafx.stage.Stage;

public class OnlineChat extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = FormService.showForm("auth", "Login");
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        new Thread(chatServer).start();
        launch(args);
    }
}
