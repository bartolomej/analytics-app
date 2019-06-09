package db;

import models.Log;
import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LogRepoTest {

    @Before
    public void doBefore() throws SQLException, ClassNotFoundException {
        Repository.init();
        //Repository.purgeDatabase();
    }

    @Test
    public void getInternalLogs() throws SQLException {
        try {
            ArrayList<Log> logs = LogRepo.getInternalLogs();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "No logs found");
        }
    }

    @Test
    public void getByApp() throws Exception {
        ArrayList<Log> logs = LogRepo.getByApp("CryptoExchange");
        assertEquals(logs, "");
    }

    @Test
    public void getAll() {
    }
}