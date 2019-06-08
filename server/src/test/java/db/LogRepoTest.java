package db;

import models.Log;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LogRepoTest {

    @Before
    public void doBefore() throws SQLException, ClassNotFoundException {
        Repository.init();
        Repository.purgeDatabase();
    }

    @Test
    public void add() {
    }

    @Test
    public void getByNode() {
    }

    @Test
    public void getByNode1() {
    }

    @Test
    public void getByUser() {
    }

    @Test
    public void getByApp() {
    }

    @Test
    public void getByApp1() {
    }
}