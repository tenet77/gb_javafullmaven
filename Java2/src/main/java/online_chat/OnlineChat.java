package online_chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OnlineChat extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent chat = FXMLLoader.load(getClass().getResource("messenger.fxml"));
        primaryStage.setTitle("Online chat");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(chat));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
