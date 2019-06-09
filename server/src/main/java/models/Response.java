package models;

import java.io.ObjectOutputStream;

public class Response {

    public String status;
    public String type;
    public int code;
    public String message;
    public Object data;

    private Response(String status, String type, int code, String message, Object data) {
        this.status = status;
        this.type = type;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response general(Object data) {
        return new Response("ok", "", 200, "", data);
    }

    public static Response notFound(String message) {
        return new Response("ok", "NotFoundError", 404, message, null);
    }

    public static Response internal(String message) {
        return new Response("ok", "InternalError", 500, message, null);
    }
}
