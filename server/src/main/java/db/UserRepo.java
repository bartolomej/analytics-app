package db;

import db.sql.Queries;
import models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserRepo {

    public static User getByUid(String uid) throws SQLException, ParseException {
        ArrayList<Map> results = Repository.executeQuery(Queries.queryUserByUid(uid));
        if (results.size() == 0) return null;
        Map user = results.get(0);
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
        Date date = format.parse((String)user.get("created"));
        return new User(
                (String)user.get("uid"),
                (String)user.get("username"),
                (String)user.get("password"),
                (String)user.get("email"),
                (String)user.get("role"),
                date,
                null
        );
    }
}
