package db.sql;

import models.User;

public class Update {

    public static String user(User user) {
        return String.format(
                "UPDATE user SET " +
                "username = '%s', " +
                "password = '%s', " +
                "email = '%s', " +
                "role = '%s'",
                user.username, user.password, user.email, user.role
        );
    }
}
