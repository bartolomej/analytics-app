import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class LoggerTest {

    @Test
    public void parseLogToJson() {
        String nodeUid = "402665f2-489f-4434-b3e4-1a163702a944";
        Log log = new Log(nodeUid, "INFO", "test", "test", new Date());

        String expected = "{\"node\":\"402665f2-489f-4434-b3e4-1a163702a944\",\"datetime\":\""
                + Utils.toStringDate(new Date()) + "\",\"extra\":\"test\",\"type\":\"INFO\",\"message\":\"test\"}";

        assertEquals(expected, log.toJson().toString());
    }

    @Test
    public void postLog() throws UnirestException {
        String uid = "ed715a73-4f35-4be2-b9ed-3b922850cbf6";
        String nodeUid = "402665f2-489f-4434-b3e4-1a163702a944";
        Log log = new Log(nodeUid, "INFO", "test", "test", new Date());

        HttpResponse<JsonNode> response = Api.addLog(nodeUid, log);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void logWithLogger() {
        String url = "http://localhost:7000";
        String nodeUid = "402665f2-489f-4434-b3e4-1a163702a944";

        Logger.init(nodeUid, url);

        Logger.log("APP", "Testing logger", "");
    }
}