package models;

import java.util.Date;

public class Log {

    private String type;
    private String message;
    private String extra;
    private Date datetime;

    public Log(String type, String message, String extra, Date datetime) {
        this.type = type;
        this.message = message;
        this.extra = extra;
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getExtra() {
        return extra;
    }

    public Date getDatetime() {
        return datetime;
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
