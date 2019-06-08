package db;

import db.sql.Select;
import models.App;
import utils.ParseUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import static db.Repository.executeQuery;

public class AppRepo {

    public static ArrayList<App> getByUser(String userUid) throws SQLException {
        return deserializeResults(executeQuery(Select.apps(userUid)));
    }

    public static ArrayList<App> getAll() throws SQLException {
        return deserializeResults(executeQuery(Select.allApps()));
    }

    private static ArrayList<App> deserializeResults(ArrayList<Map> results) {
        ArrayList<App> apps = new ArrayList<>();
        for (Map entry : results) {
            Date date = ParseUtil.toJavaDate((String)entry.get("created"));
            apps.add(new App(
                    (String)entry.get("name"),
                    (String)entry.get("url"),
                    (String)entry.get("description"),
                    date
            ));
        }
        return apps;
    }

}
