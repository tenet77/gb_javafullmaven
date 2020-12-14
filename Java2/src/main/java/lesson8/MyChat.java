package lesson8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyChat extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("chat.fxml"));

        Parent chat = loader.load();

        stage.setTitle("Chat");
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();

        ChatController controller = loader.getController();

        stage.setOnCloseRequest(controller.getCloseEventHandler());

    }

    public static void main(String[] args) {
        launch(args);
    }

}
