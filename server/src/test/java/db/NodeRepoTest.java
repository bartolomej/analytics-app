package db;

import models.Node;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class NodeRepoTest {

    @Before
    public void doBefore() throws SQLException, ClassNotFoundException {
        Repository.init();
        //Repository.purgeDatabase();
    }

    @Test
    public void getByApp() throws SQLException {
        ArrayList<Node> nodes = NodeRepo.getByApp("CryptoExchange");
        assertEquals("", nodes);
    }
}