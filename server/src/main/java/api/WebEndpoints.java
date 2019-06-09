package api;

import db.AccountRepo;
import db.AppRepo;
import db.LogRepo;
import db.NodeRepo;
import io.javalin.Javalin;
import models.*;

import java.util.ArrayList;
import java.util.Date;

public class WebEndpoints {

    Javalin app;

    public WebEndpoints(Javalin app) {
        this.app = app;
        this.routesHandler();
    }

    private void routesHandler() {

        app.get("/api/user/:useruid", ctx -> {
            User user = AccountRepo.getUserByUid(ctx.pathParam("useruid"));
            ctx.json(Response.general(user));
        });

        app.get("/api/user/:useruid/app", ctx -> {
            ArrayList<App> apps = AppRepo.getByUser(ctx.pathParam("useruid"));
            ctx.json(Response.general(apps));
        });

        app.get("/api/user/:useruid/app/:appname/log", ctx -> {
            ArrayList<Log> logs = LogRepo.getByApp(ctx.pathParam("appname"));
            ctx.json(Response.general(logs));
        });

        app.get("/api/user/:useruid/app/:appname/node", ctx -> {
            ArrayList<Node> nodes = NodeRepo.getByApp(ctx.pathParam("appname"));
            ctx.json(Response.general(nodes));
        });

    }
}
