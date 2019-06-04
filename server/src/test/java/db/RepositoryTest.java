package db;

import org.junit.Test;
import scripts.Run;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

public class RepositoryTest {

    // TODO: execute shell script with test data

    @Test
    public void testEmptyQuery() throws SQLException, ClassNotFoundException, IOException {
        Repository.init();
        ArrayList<Map> result = Repository.executeQuery("SELECT * FROM user WHERE 0=1;");
        assertEquals(result.size(), 0);
    }

    @Test
    public void testUserQuery() throws SQLException, ClassNotFoundException {
        Repository.init();
        ArrayList<Map> result = Repository.executeQuery("SELECT * FROM user;");
        assertEquals(result.size(), 3);
    }

}