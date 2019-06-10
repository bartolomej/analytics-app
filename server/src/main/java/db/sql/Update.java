package db.sql;

import models.App;
import models.User;

public class Update {

    public static String user(User user) {
        return String.format(
                "UPDATE user SET " +
                "username = '%s', " +
                "password = '%s', " +
                "email = '%s', " +
                "role = '%s'" +
                "WHERE uid = '%s'",
                user.username, user.password, user.email, user.role, user.uid
        );
    }

    public static String app(App app) {
        return String.format(
                "UPDATE user SET " +
                 //"name = %s, " + /// TODO: cant update name if primary key
                 "description = %s " +
                 "name = %s",
                app.description, app.name
        );
    }
}
