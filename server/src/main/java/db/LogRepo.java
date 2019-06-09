package db;

import db.sql.Insert;
import db.sql.Select;
import models.Log;
import utils.ParseUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import static db.Repository.executeManipulation;
import static db.Repository.executeQuery;

public class LogRepo {

    public static void add(Log log) throws SQLException {
        executeManipulation(Insert.log(log));
    }

    public static ArrayList<Log> getInternalLogs() throws Exception {
        return deserializeResults(executeQuery(Select.internalLogs()));
    }

    public static ArrayList<Log> getInternalLogs(Date start) throws Exception {
        return deserializeResults(executeQuery(Select.internalLogsFromDate(start)));
    }

    public static ArrayList<Log> getInternalLogs(String type) throws Exception {
        return deserializeResults(executeQuery(Select.internalLogsWithType(type)));
    }

    public static ArrayList<Log> getByNode(String nodeUid) throws Exception {
        return deserializeResults(executeQuery(Select.nodeLogs(nodeUid)));
    }

    public static ArrayList<Log> getByNode(String nodeUid, Date from) throws Exception {
        return deserializeResults(executeQuery(Select.nodeLogsFromDate(nodeUid, from)));
    }

    public static ArrayList<Log> getByUser(String userUid) throws Exception {
        return deserializeResults(executeQuery(Select.logsByUser(userUid)));
    }

    public static ArrayList<Log> getByApp(String appName) throws Exception {
        return deserializeResults(executeQuery(Select.appLogs(appName)));
    }

    public static ArrayList<Log> getByApp(String appName, Date from) throws Exception {
        return deserializeResults(executeQuery(Select.appLogs(appName, from)));
    }

    public static ArrayList<Log> getAll() throws Exception {
        return deserializeResults(executeQuery(Select.allLogs()));
    }

    private static ArrayList<Log> deserializeResults(ArrayList<Map> results) {
        ArrayList<Log> logs = new ArrayList<>();
        for (Map entry : results) {
            logs.add(deserialize(entry));
        }
        return logs;
    }

    private static Log deserialize(Map entry) {
        Date date = ParseUtil.toJavaDate((String)entry.get("datetime"));
        return new Log(
                (String)entry.get("node"),
                (String)entry.get("type"),
                (String)entry.get("message"),
                (String)entry.get("extra"),
                date
        );
    }
}
