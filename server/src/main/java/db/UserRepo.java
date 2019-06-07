package db;

import db.sql.Delete;
import db.sql.Insert;
import db.sql.Select;
import models.App;
import models.User;
import utils.DbParseUtil;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

import static db.Repository.executeManipulation;
import static db.Repository.executeQuery;

public class UserRepo {

    public static void add(User user) throws SQLException {
        executeManipulation(Insert.user(user));
    }

    public static User getByUid(String uid) throws SQLException, ParseException {
        ArrayList<Map> results = executeQuery(Select.user(uid));
        if (results.size() == 0) return null;
        Map user = results.get(0);
        Date date = DbParseUtil.parseSqlDate((String)user.get("created"));
        return new User(
                (String)user.get("uid"),
                (String)user.get("username"),
                (String)user.get("password"),
                (String)user.get("email"),
                (String)user.get("role"),
                date,
                null
        );
    }

    public static ArrayList<User> getAll() throws SQLException, ParseException {
        ArrayList<Map> results = executeQuery(Select.allUsers());
        ArrayList<User> users = new ArrayList<>();
        for (Map entry : results) {
            Date date = DbParseUtil.parseSqlDate((String)entry.get("created"));
            users.add(new User(
                    (String)entry.get("uid"),
                    (String)entry.get("username"),
                    (String)entry.get("password"),
                    (String)entry.get("email"),
                    (String)entry.get("role"),
                    date,
                    null
            ));
        }
        return users;
    }

    public static ArrayList<App> getApps(String userUid) throws SQLException, ParseException {
        ArrayList<Map> results = executeQuery(Select.apps(userUid));
        ArrayList<App> apps = new ArrayList<>();
        for (Map entry : results) {
            Date date = DbParseUtil.parseSqlDate((String)entry.get("created"));
            apps.add(new App(
                    (String)entry.get("name"),
                    (String)entry.get("url"),
                    (String)entry.get("description"),
                    date
            ));
        }
        return apps;
    }

    public static void remove(String uid) throws SQLException {
        executeManipulation(Delete.user(uid));
    }

    public static void removeAll() throws SQLException {
        executeManipulation(Delete.allUsers());
    }

}
