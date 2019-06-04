package models;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

public class User {

    public String uid;
    public String email;
    public String username;
    public String password;
    public String role;
    public Date created;
    public ArrayList<App> apps;

    public User(String uid, String username, String password, String email, String role, Date created, ArrayList<App> apps) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.created = created;
        this.apps = apps;
    }

    public boolean equals(User user) {
        return (
                this.uid.equals(user.uid) &&
                this.email.equals(user.email) &&
                this.username.equals(user.username) &&
                this.password.equals(user.password) &&
                this.role.equals(user.role) &&
                this.created.equals(user.created)
        );
    }
}
