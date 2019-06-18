import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Date;

public class Logger {

    static String nodeUid;

    public static void init(String node, String serverUrl) {
        nodeUid = node;
        Api.init(serverUrl);
    }

    public static void log(String type, String message, String extra) {
        Log log = new Log(nodeUid, type, message, extra, new Date());
        try {
            Api.addLog(nodeUid, log);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
