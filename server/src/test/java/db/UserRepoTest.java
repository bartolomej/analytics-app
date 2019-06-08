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
        Repository.purgeDatabase();
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

        UserRepo.add(expected);

        User actual = UserRepo.getByUid("1");
        assertTrue(expected.equals(actual));
    }

    @Test
    public void updateUser() throws Exception {
        User expected = new User("1",
                "testUsername",
                "testPass",
                "test@email.com",
                "user", new Date(),
                null
        );

        User updated = new User("1",
                "updatedUsername",
                "updatedPassword",
                "updatedmail@email.com",
                "updatedRole", new Date(),
                null
        );

        UserRepo.add(expected);

        UserRepo.update(updated);

        User user = UserRepo.getByUid("1");

        assertTrue(user.equals(updated));
    }
}