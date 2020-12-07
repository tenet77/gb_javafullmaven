package online_chat;

public interface IAuthService {
    void add(String name, String pass);
    boolean auth(String name, String pass);
}
