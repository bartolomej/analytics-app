package db;

import db.sql.Delete;
import db.sql.Insert;
import db.sql.Select;
import db.sql.Update;
import models.Admin;
import models.User;
import utils.ParseUtil;

import java.sql.SQLException;
import java.util.*;

import static db.Repository.*;

public class AccountRepo {

    public static Admin add(Admin admin) throws SQLException {
        executeManipulation(Insert.admin(admin));
        return admin;
    }

    public static User add(User user) throws SQLException {
        executeManipulation(Insert.user(user));
        return user;
    }

    public static User getUserByUid(String uid) throws Exception {
        ArrayList<Map> results = executeQuery(Select.user(uid));
        if (results.size() == 0) throw new Exception("User " + uid + " not found");
        Map user = results.get(0);
        return deserializeUser(user);
    }

    public static Admin getAdminByUid(String uid) throws Exception {
        ArrayList<Map> results = executeQuery(Select.admin(uid));
        if (results.size() == 0) throw new Exception("Admin " + uid + " not found");
        Map user = results.get(0);
        return deserializeAdmin(user);
    }

    public static ArrayList<Map> getUserStats(String period) throws SQLException {
        return executeQuery(Select.userStatsByDuration(period));
    }

    public static ArrayList<User> getAllCoworkers(String userUid) throws SQLException {
        ArrayList<Map> results = executeQuery(Select.allCoworkers(userUid));
        ArrayList<User> users = new ArrayList<>();
        for (Map entry : results) {
            users.add(deserializeUser(entry));
        }
        return users;
    }

    public static ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<Map> results = executeQuery(Select.allUsers());
        ArrayList<User> users = new ArrayList<>();
        for (Map entry : results) {
            users.add(deserializeUser(entry));
        }
        return users;
    }

    public static ArrayList<Admin> getAllAdmins() throws SQLException {
        ArrayList<Map> results = executeQuery(Select.allAdmins());
        ArrayList<Admin> admins = new ArrayList<>();
        for (Map entry : results) {
            admins.add(deserializeAdmin(entry));
        }
        return admins;
    }

    public static User update(User user) throws SQLException {
        executeUpdate(Update.user(user));
        return user;
    }

    public static void removeUser(String uid) throws SQLException {
        executeManipulation(Delete.user(uid));
    }

    private static User deserializeUser(Map entry) {
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

    private static Admin deserializeAdmin(Map entry) {
        Date date = ParseUtil.toJavaDate((String)entry.get("created"));
        return new Admin(
                (String)entry.get("uid"),
                (String)entry.get("username"),
                (String)entry.get("password"),
                date
        );
    }

}
