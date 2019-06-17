package db;

import db.sql.Select;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ExperimentalTesting {

    @Test
    public void userStats() throws SQLException {
        ArrayList<Map> stats = AccountRepo.getUserStats("minute");
        String query = Select.userStatsByDuration("hour");
        assertEquals("", query);
    }
}
