package db.sql;

import models.*;
import utils.ParseUtil;

import java.util.Date;

public class Insert {

    public static String user(User user) {
        return String.format(
                "INSERT INTO user (uid, username, password, created, email, role)" +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                user.uid, user.username, user.password,
                ParseUtil.toSqlDate(user.created), user.email, user.role
        );
    }

    public static String app(App app) {
        return String.format(
                "INSERT INTO app (name, url, description, created) " +
                "VALUES ('%s', '%s', '%s', '%s')",
                app.name, app.url, app.description, ParseUtil.toSqlDate(app.created)
        );
    }

    public static String appOwnership(String userUid, String appName) {
        return String.format(
                "INSERT INTO ownership (user, app, added) " +
                "VALUES ('%s', '%s', '%s')",
                userUid, appName, ParseUtil.toSqlDate(new Date())
        );
    }

    public static String log(Log log) {
        return String.format(
                "INSERT INTO log (type, datetime, message, extra, node) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s')",
                log.type, ParseUtil.toSqlDate(log.datetime), log.message, log.extra, log.node
        );
    }

    public static String admin(Admin admin) {
        return String.format(
                "INSERT INTO log (uid, username, password, created) " +
                "VALUES ('%s', '%s', '%s', '%s')",
                admin.uid, admin.username, admin.password, ParseUtil.toSqlDate(admin.created)
        );
    }

    public static String node(Node node) {
        return String.format(
                "INSERT INTO node (uid, url, created, app) " +
                "VALUES ('%s', '%s', '%s', '%s')",
                node.uid, node.url, ParseUtil.toSqlDate(node.created), node.app
        );
    }

    public static String graphRelation(String fromNode, String toNode) {
        return String.format(
                "INSERT INTO graph (from_node, to_node, created) " +
                "VALUES ('%s', '%s', '%s')",
                fromNode, toNode, ParseUtil.toSqlDate(new Date())
        );
    }

}
