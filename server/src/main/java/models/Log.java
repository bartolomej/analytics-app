package models;

import java.util.Date;

public class Log {

    public String node;
    public String type;
    public String message;
    public String extra;
    public Date datetime;

    public Log(String node, String type, String message, String extra, Date datetime) {
        this.node = node;
        this.type = type;
        this.message = message;
        this.extra = extra;
        this.datetime = datetime;
    }

    public String toString() {
        return String.format("{type: %s, message: %s, extra: %s, datetime: %s}",
                this.type,
                this.message,
                this.extra,
                this.datetime.toString()
        );
    }
}
