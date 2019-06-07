package models;

import java.util.Date;

public class Admin {

    public String uid;
    public String username;
    public String password;
    public Date created;

    public Admin(String uid, String username, String password, Date created) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.created = created;
    }
}
