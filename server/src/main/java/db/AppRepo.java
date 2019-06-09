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

    public static ArrayList<App> getByUser(String userUid) throws Exception {
        return deserializeResults(executeQuery(Select.apps(userUid)));
    }

    public static App getByName(String name) throws Exception {
        return deserializeResults(executeQuery(Select.app(name))).get(0);
    }

    public static ArrayList<App> getAll() throws Exception {
        return deserializeResults(executeQuery(Select.allApps()));
    }

    private static ArrayList<App> deserializeResults(ArrayList<Map> results) throws Exception {
        ArrayList<App> apps = new ArrayList<>();
        if (results.size() == 0) throw new Exception("App not found");
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
