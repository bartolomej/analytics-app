package db.sql;

import utils.ParseUtil;

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

    public static String allApps() {
        return "SELECT * FROM app";
    }

    public static String appNodes(String appName) {
        return String.format(
                "SELECT * FROM node " +
                "WHERE node.app = '%s'", appName);
    }

    public static String allNodes() {
        return "SELECT * FROM node";
    }

    public static String nodeEdges(String nodeUid) {
        return String.format(
                "SELECT * FROM graph " +
                "WHERE graph.from = '%s'",
                nodeUid
        );
    }

    public static String logsByUser(String userUid) {
        return String.format(
                "SELECT * FROM log " +
                "INNER JOIN node " +
                "ON node.uid = log.node " +
                "INNER JOIN app " +
                "ON app.name = node.app " +
                "INNER JOIN ownership " +
                "ON ownership.app = app.name " +
                "WHERE ownership.user = '%s'",
                userUid
        );
    }

    public static String allLogs() {
        return "SELECT * FROM log";
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
                "SELECT * FROM log l " +
                "INNER JOIN node n " +
                "ON n.uid = l.node " +
                "WHERE n.app = '%s' " +
                "AND l.datetime > '%s'",
                appName, ParseUtil.toSqlDate(from));
    }

    public static String nodeLogs(String uid) {
        return String.format(
                "SELECT * FROM log l" +
                "WHERE l.node = '%s'", uid);
    }

    public static String nodeLogsFromDate(String uid, Date date) {
        return String.format(
                "SELECT * FROM log l" +
                "WHERE l.node = '%s'" +
                "AND l.datetime > '%s'",
                uid, ParseUtil.toSqlDate(date));
    }

    public static String allUsers() {
        return "SELECT * FROM user";
    }

}
