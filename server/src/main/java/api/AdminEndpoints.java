package api;

import db.AppRepo;
import db.LogRepo;
import db.NodeRepo;
import db.AccountRepo;
import io.javalin.Javalin;
import models.*;

import java.util.ArrayList;

public class AdminEndpoints {

    Javalin app;

    public AdminEndpoints(Javalin app) {
        this.app = app;
        this.routesHandler();
    }

    private void routesHandler() {

        app.get("/api/admin", ctx -> {
            ctx.json(Response.general(null));
        });

        app.get("/api/admin/:uid", ctx -> {
            Admin admin = AccountRepo.getAdminByUid(ctx.pathParam("uid"));
            ctx.json(Response.general(admin));
        });

        app.get("/api/admin/:uid/admins", ctx -> {
            // is super admin ?
            ArrayList<Admin> admins = AccountRepo.getAllAdmins();
            ctx.json(Response.general(admins));
        });

        app.get("/api/admin/:uid/user", ctx -> {
            ArrayList<User> users = AccountRepo.getAllUsers();
            ctx.json(Response.general(users));
        });

        app.get("/api/admin/:adminuid/user/:useruid", ctx -> {
            User user = AccountRepo.getUserByUid(ctx.pathParam("useruid"));
            ctx.json(Response.general(user));
        });

        app.get("/api/admin/:uid/app", ctx -> {
            ArrayList<App> apps = AppRepo.getAll();
            ctx.json(Response.general(apps));
        });

        app.get("/api/admin/:adminuid/app/:appname", ctx -> {
            App app = AppRepo.getByName(ctx.pathParam("appname"));
            ctx.json(Response.general(app));
        });

        app.get("/api/admin/:uid/log", ctx -> {
            ArrayList<Log> logs = LogRepo.getInternalLogs();
            ctx.json(Response.general(logs));
        });

        app.get("/api/admin/:adminuid/log/:type", ctx -> {
            ArrayList<Log> logs = LogRepo.getInternalLogs(ctx.pathParam("type"));
            ctx.json(Response.general(logs));
        });

        app.get("/api/admin/:uid/node", ctx -> {
            ArrayList<Node> nodes = NodeRepo.getAll();
            ctx.json(Response.general(nodes));
        });

        // TODO: add POST, PUT endpoints
    }
}
