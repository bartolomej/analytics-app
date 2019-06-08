package utils;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class ParseUtilTest {

    @Test
    public void parseDates() {
        Date expected = new Date();
        String sqlDate = ParseUtil.toSqlDate(expected);
        Date actual = ParseUtil.toJavaDate(sqlDate);
        assertEquals(expected.toString(), actual.toString());
    }

}