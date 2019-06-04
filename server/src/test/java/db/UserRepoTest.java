package db;

import models.User;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class UserRepoTest {

    @Test
    public void getByUid() throws SQLException, ParseException, ClassNotFoundException {
        //User expected = new User("");

        Repository.init();
        User user = UserRepo.getByUid("1");

        assertTrue(user.equals(null));
    }
}