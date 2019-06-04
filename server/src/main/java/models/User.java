package models;

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
}
