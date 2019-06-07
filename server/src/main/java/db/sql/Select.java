package db.sql;

import java.util.Date;

public class Select {

    public static String admin(String uid) {
        return String.format(
                "SELECT * FROM admin " +
                "WHERE admin.uid = '%s'", uid);
    }

    public static String user(String uid) {
        return String.format(
                "SELECT * FROM user " +
                "WHERE uid = '%s'", uid);
    }

    public static String apps(String userUid) {
        return String.format(
                "SELECT * FROM app a " +
                "INNER JOIN ownership o " +
                "ON a.name = o.app " +
                "WHERE o.user = '%s'", userUid);
    }

    public static String appNodes(String appName) {
        return String.format(
                "SELECT * FROM node " +
                "WHERE node.app = '%s'", appName);
    }

    public static String appLogs(String appName) {
        return String.format(
                "SELECT * FROM log l" +
                "INNER JOIN node n " +
                "ON n.uid = l.node " +
                "WHERE n.app = '%s'", appName);
    }

    public static String appLogs(String appName, Date from) {
        return String.format(
                "SELECT * FROM log l" +
                "INNER JOIN node n " +
                "ON n.uid = l.node " +
                "WHERE n.app = '%s' " +
                "AND l.datetime > '%s'",
                appName, from.toString()); // TODO: parse date
    }

    public static String queryNodeLogs(String uid) {
        return String.format(
                "SELECT * FROM log l" +
                "WHERE l.node = '%s'", uid);
    }

    public static String queryNodeLogsFromDate(String uid, Date date) {
        return String.format(
                "SELECT * FROM log l" +
                "WHERE l.node = '%s'" +
                "AND l.datetime > '%s'",
                uid, date.toString()); // TODO: parse date
    }

    public static String allUsers() {
        return "SELECT * FROM user";
    }

}
