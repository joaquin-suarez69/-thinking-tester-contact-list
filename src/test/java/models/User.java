package models;

import lombok.Data;

@Data
public class User {
    private static User user = null;
    String email;
    String password;

    private User() {
    }
    public static synchronized User getInstance(){
        if(user == null)
            user = new User();
        return user;
    }
}
