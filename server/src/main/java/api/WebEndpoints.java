package api;

import io.javalin.Javalin;
import models.User;

import java.util.Date;

public class WebEndpoints {

    Javalin app;

    public WebEndpoints(Javalin app) {
        this.app = app;
        this.routesHandler();
    }

    private void routesHandler() {

        app.get("/", ctx -> {
            ctx.json("ok");
        });

        app.get("/test", ctx -> {
            ctx.json(new User("1", "bart", "pass", "bart.dev@mail.com", "developer", new Date(), null));
        });
    }
}
