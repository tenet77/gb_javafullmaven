package server_client;

public class MyApp {

    public static void main(String[] args) {

        new Thread(new MyServer()).start();

    }

}
