package services;

import db.LogRepo;
import models.Log;

import java.sql.SQLException;
import java.util.Date;

public class Logger {

    public static void error(String message, String extra) {
        Log log = new Log(null, "ERROR", message, extra, new Date());
        try {
            LogRepo.add(log);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void app(String message, String extra) {
        Log log = new Log(null, "APP", message, extra, new Date());
        try {
            LogRepo.add(log);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void info(String message, String extra) {
        Log log = new Log(null, "INFO", message, extra, new Date());
        try {
            LogRepo.add(log);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
