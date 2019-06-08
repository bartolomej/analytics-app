package api;

import db.AppRepo;
import db.LogRepo;
import db.NodeRepo;
import db.UserRepo;
import io.javalin.Javalin;
import models.*;

import java.util.ArrayList;
import java.util.Date;

public class AdminEndpoints {

    Javalin app;

    public AdminEndpoints(Javalin app) {
        this.app = app;
        this.routesHandler();
    }

    private void routesHandler() {

        app.get("/admin", ctx -> {
            ctx.status(200);
        });

        app.get("/admin/users", ctx -> {
            ArrayList<User> users = UserRepo.getAll();
            ctx.json(users);
        });

        app.get("/admin/apps", ctx -> {
            ArrayList<App> apps = AppRepo.getAll();
            ctx.json(apps);
        });

        app.get("/admin/logs", ctx -> {
            ArrayList<Log> logs = LogRepo.getAll();
            ctx.json(logs);
        });

        app.get("/admin/nodes", ctx -> {
            ArrayList<Node> nodes = NodeRepo.getAll();
            ctx.json(nodes);
        });
    }
}
