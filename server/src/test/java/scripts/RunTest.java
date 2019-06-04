package scripts;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RunTest {

    @Test
    public void initDb() throws IOException {
        Run.initTables();
    }
}