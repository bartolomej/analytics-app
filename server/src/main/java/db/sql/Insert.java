package db.sql;

import models.*;

import java.util.Date;

public class Insert {

    public static String user(User user) {
        return String.format(
                "INSERT INTO user (uid, username, password, created, email, role)" +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                user.uid, user.username, user.password,
                "2019-05-05", user.email, user.role // TODO: serialize date
        );
    }

    public static String app(App app) {
        return String.format(
                "INSERT INTO app (name, url, description, created) " +
                "VALUES ('%s', '%s', '%s', '%s')",
                app.name, app.url, app.description, app.created
        );
    }

    public static String appOwnership(String userUid, String appName) {
        return String.format(
                "INSERT INTO ownership (user, app, added) " +
                "VALUES ('%s', '%s', '%s')",
                userUid, appName, new Date()
        );
    }

    public static String log(Log log) {
        return String.format(
                "INSERT INTO log (type, datetime, message, extra, node) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s')",
                log.type, log.datetime, log.message, log.extra, log.node
        );
    }

    public static String admin(Admin admin) {
        return String.format(
                "INSERT INTO log (uid, username, password, created) " +
                "VALUES ('%s', '%s', '%s', '%s')",
                admin.uid, admin.username, admin.password, admin.created
        );
    }

    public static String node(Node node) {
        return String.format(
                "INSERT INTO node (uid, url, created, app) " +
                "VALUES ('%s', '%s', '%s', '%s')",
                node.uid, node.url, node.created, node.app
        );
    }

    public static String graphRelation(String fromNode, String toNode) {
        return String.format(
                "INSERT INTO graph (from_node, to_node, created) " +
                "VALUES ('%s', '%s', '%s')",
                fromNode, toNode, new Date()
        );
    }

}
