package db;

import db.sql.Delete;
import db.sql.Insert;
import db.sql.Select;
import db.sql.Update;
import models.User;
import utils.ParseUtil;

import java.sql.SQLException;
import java.util.*;

import static db.Repository.*;

public class UserRepo {

    public static void add(User user) throws SQLException {
        executeManipulation(Insert.user(user));
    }

    public static User getByUid(String uid) throws SQLException {
        ArrayList<Map> results = executeQuery(Select.user(uid));
        if (results.size() == 0) return null;
        Map user = results.get(0);
        return deserialize(user);
    }

    public static ArrayList<User> getAll() throws SQLException {
        ArrayList<Map> results = executeQuery(Select.allUsers());
        ArrayList<User> users = new ArrayList<>();
        for (Map entry : results) {
            users.add(deserialize(entry));
        }
        return users;
    }

    public static User update(User user) throws SQLException {
        executeUpdate(Update.user(user));
        return user;
    }

    public static void remove(String uid) throws SQLException {
        executeManipulation(Delete.user(uid));
    }

    private static User deserialize(Map entry) {
        Date date = ParseUtil.toJavaDate((String)entry.get("created"));
        return new User(
                (String)entry.get("uid"),
                (String)entry.get("username"),
                (String)entry.get("password"),
                (String)entry.get("email"),
                (String)entry.get("role"),
                date,
                null
        );
    }

}
