package db.sql;


public class Delete {

    public static String app(String uid) {
        return String.format(
                "DELETE FROM app WHERE uid = '%s'", uid
        );
    }

    public static String appOwnership(String uid) {
        return String.format(
                "DELETE FROM ownership WHERE uid = '%s'", uid
        );
    }

    public static String log(String uid) {
        return String.format(
                "DELETE FROM log WHERE uid = '%s'", uid
        );
    }

    public static String admin(String uid) {
        return String.format(
                "DELETE FROM admin WHERE uid = '%s'", uid
        );
    }

    public static String node(String uid) {
        return String.format(
                "DELETE FROM node WHERE uid = '%s'", uid
        );
    }

    public static String graph(String uid) {
        return String.format(
                "DELETE FROM graph WHERE uid = '%s'", uid
        );
    }

    public static String user(String uid) {
        return String.format(
                "DELETE FROM user WHERE uid = '%s'", uid
        );
    }

    public static String allApps() {
        return "DELETE FROM app";
    }

    public static String allAppOwnership() {
        return "DELETE FROM ownership";
    }

    public static String allLogs() {
        return "DELETE FROM log";
    }

    public static String allAdmins() {
        return "DELETE FROM admin";
    }

    public static String allNodes() {
        return "DELETE FROM node";
    }

    public static String allGraphRelations() {
        return "DELETE FROM graph";
    }

    public static String allUsers() {
        return "DELETE FROM user";
    }

}