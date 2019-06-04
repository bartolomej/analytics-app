package db.sql;

public class Queries {

    public static String queryUserByUid(String uid) {
        return String.format("SELECT * FROM user WHERE uid = %s", uid);
    }
}
