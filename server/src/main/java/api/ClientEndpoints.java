package api;

import db.LogRepo;
import io.javalin.Javalin;
import models.Log;
import models.Response;
import models.User;

public class ClientEndpoints {

    Javalin app;

    public ClientEndpoints(Javalin app) {
        this.app = app;
        this.routesHandler();
    }

    private void routesHandler() {

        app.post("/api/node/:nodeuid/log", ctx -> {
            Log log = ctx.bodyAsClass(Log.class);
            LogRepo.add(log);
            ctx.json(Response.general(log));
        });

    }
}
