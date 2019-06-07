package models;


import java.util.Date;

public class App {

    public String name;
    public String url;
    public String description;
    public Date created;

    public App(String name, String url, String description, Date created) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.created = created;
    }

}
