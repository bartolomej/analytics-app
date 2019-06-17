import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public class Api {

    public static HttpResponse<JsonNode> addLog(String nodeUid, Log log) throws UnirestException {
        return Unirest.post("http://localhost:7000/api/node/" + nodeUid + "/log")
                .header("accept", "application/json")
                .body(log.toJson())
                .asJson();
    }
}
