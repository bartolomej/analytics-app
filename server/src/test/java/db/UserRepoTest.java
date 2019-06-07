package db;

import models.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class UserRepoTest {

    @Before
    public void doBefore() throws SQLException, ClassNotFoundException {
        Repository.init();
        UserRepo.removeAll();
    }

    @Test
    public void addUser() throws SQLException, ClassNotFoundException, ParseException {
        User expected = new User("1",
                "testUsername",
                "testPass",
                "test@email.com",
                "user", new Date(),
                null
        );

        Repository.init();
        UserRepo.add(expected);

        User actual = UserRepo.getByUid("1"); // TODO: parse date
        assertTrue(expected.equals(actual));
    }

    @Test
    public void getByUid() throws SQLException, ParseException, ClassNotFoundException {


        User user = UserRepo.getByUid("1");

        assertTrue(user.equals(null));
    }
}