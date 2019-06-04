package db.sql;

import java.util.HashMap;
import java.util.Map;

public class Definition {

    public static Map<Schema, String> getAll() {
        Map<Schema, String> statements = new HashMap<>();
        statements.put(Schema.USER, createUserTable());
        statements.put(Schema.APP, createAppTable());
        statements.put(Schema.LOG, createLogTable());
        statements.put(Schema.ADMIN, createAdminTable());
        statements.put(Schema.NODE, createNodeTable());
        statements.put(Schema.GRAPH, createGraphTable());
        return statements;
    }

    public static String createUserTable() {
        return ("CREATE TABLE user (" +
                "uid varchar(100) primary key," +
                "username varchar(30)," +
                "password varchar(100)," +
                "created date," +
                "email varchar(50)," +
                "role varchar(30)," +
                ");"
        );
    }

    public static String createAppTable() {
        return ("CREATE TABLE app (" +
                "name varchar(10) primary key," +
                "url varchar(50)," +
                ");"
        );
    }

    public static String createLogTable() {
        return ("CREATE TABLE log (" +
                "id int auto_increment primary key," +
                "type varchar(50)," +
                "datetime date," +
                "message varchar(50)," +
                "extra varchar(100)," +
                ");"
        );
    }

    private static String createAdminTable() {
        return ("CREATE TABLE admin (" +
                "uid varchar(100) primary key," +
                "username varchar(30)," +
                "password varchar(100)," +
                "created date" +
                ");"
        );
    }

    private static String createNodeTable() {
        return ("CREATE TABLE node (" +
                "uid varchar(100) primary key," +
                "address varchar(30)," +
                "created date" +
                ");"
        );
    }

    private static String createGraphTable() {
        return ("CREATE TABLE node (" +
                "uid varchar(100) primary key," +
                "name varchar(50)," +
                "from_node varchar(100)," +
                "to_node varchar(100)," +
                "created date" +
                ");"
        );
    }
}
