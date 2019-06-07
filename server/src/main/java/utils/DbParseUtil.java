package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DbParseUtil {

    // TODO: use LocalDate
    // https://stackoverflow.com/questions/530012/how-to-convert-java-util-date-to-java-sql-date

    public static Date parseSqlDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
       return format.parse(date);
    }

    public static String parseJavaDate(Date date) {
        // TODO: implement conversion to string sql data
        return null;
    }

    public static java.sql.Date parse(Date date) {
        return java.sql.Date.valueOf(date.toString());
    }

    public static Date parse(java.sql.Date date) {
        return null;
    }
}
