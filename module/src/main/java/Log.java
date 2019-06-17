import org.json.JSONObject;

import java.util.Date;

public class Log {

    public String node;
    public String type;
    public String message;
    public String extra;
    public Date datetime; // instantiation date format: 2011-11-02T02:50:12.208Z

    public Log(String node, String type, String message, String extra, Date datetime) {
        this.node = node;
        this.type = type;
        this.message = message;
        this.extra = extra;
        this.datetime = datetime;
    }

    public boolean valid() {
        return (this.node != null && this.node.length() > 30);
    }

    public String toString() {
        return String.format("{type: %s, message: %s, extra: %s, datetime: %s}",
                this.type,
                this.message,
                this.extra,
                this.datetime.toString()
        );
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("node", this.node);
        jsonObject.put("type", this.type);
        jsonObject.put("message", this.message);
        jsonObject.put("extra", this.extra);
        jsonObject.put("datetime", Utils.toStringDate(this.datetime));
        return jsonObject;
    }
}
