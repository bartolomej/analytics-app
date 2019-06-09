package db;

import models.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class AccountRepoTest {

    @Before
    public void doBefore() throws SQLException, ClassNotFoundException {
        Repository.init();
        Repository.purgeDatabase();
    }

    @Test
    public void addUser() throws Exception {
        User expected = new User("1",
                "testUsername",
                "testPass",
                "test@email.com",
                "user", new Date(),
                null
        );

        AccountRepo.add(expected);

        User actual = AccountRepo.getUserByUid("1");
        assertTrue(expected.equals(actual));
    }

    @Test
    public void getNonExistingUser() throws Exception {
        try {
            User actual = AccountRepo.getUserByUid("1");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "User 1 not found");
        }
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

        AccountRepo.add(expected);
        AccountRepo.update(updated);

        User user = AccountRepo.getUserByUid("1");

        assertTrue(user.equals(updated));
    }
}