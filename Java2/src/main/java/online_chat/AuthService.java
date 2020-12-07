package online_chat;

import java.util.HashMap;

public class AuthService implements IAuthService {

    private static AuthService instance;
    private HashMap userMap;


    public AuthService() {
        this.userMap = new HashMap();
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    @Override
    public void add(String name, String pass) {
        userMap.put(name, pass);
    }

    @Override
    public boolean auth(String name, String pass) {
        return userMap.containsKey(name) && userMap.get(name).equals(pass);
    }
}
