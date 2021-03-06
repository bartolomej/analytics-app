package api;

import db.AppRepo;
import db.LogRepo;
import db.NodeRepo;
import db.AccountRepo;
import io.javalin.Javalin;
import models.*;

import java.util.ArrayList;
import java.util.Map;

public class AdminEndpoints {

    Javalin app;

    public AdminEndpoints(Javalin app) {
        this.app = app;
        this.routesHandler();
    }

    private void routesHandler() {

        // STATISTICS ENDPOINTS //

        app.get("/api/admin/:adminuid/app/:appUid/log/stats", ctx -> {
            ArrayList<Map> logs = LogRepo.getAppLogStats(ctx.pathParam("appUid"), ctx.queryParam("period"));
            ctx.json(Response.general(logs));
        });

        app.get("/api/admin/:uid/log/stats", ctx -> {
            String timePeriod = ctx.queryParam("period");
            ArrayList<Map> stats = LogRepo.getInternalLogStats(timePeriod);
            ctx.json(Response.general(stats));
        });

        app.get("/api/admin/:uid/user/stats", ctx -> {
            ArrayList<Map> users = AccountRepo.getUserStats(ctx.queryParam("period"));
            ctx.json(Response.general(users));
        });

        app.get("/api/admin/:uid/app/stats", ctx -> {
            ArrayList<Map> appStats = AppRepo.getAppStats(ctx.queryParam("period"));
            ctx.json(Response.general(appStats));
        });

        // GET ENDPOINTS //

        app.get("/api/admin", ctx -> {
            ctx.json(Response.general(null));
        });

        app.get("/api/admin/:uid", ctx -> {
            Admin admin = AccountRepo.getAdminByUid(ctx.pathParam("uid"));
            ctx.cookie("Access-Control-Allow-Origin", "*");
            ctx.json(Response.general(admin));
        });

        app.get("/api/admin/:uid/admins", ctx -> {
            ArrayList<Admin> admins = AccountRepo.getAllAdmins();
            ctx.json(Response.general(admins));
        });

        app.get("/api/admin/:uid/user", ctx -> {
            ArrayList<User> users = AccountRepo.getAllUsers();
            ctx.json(Response.general(users));
        });

        app.get("/api/admin/:uid/user/:userUid/log", ctx -> {
            ArrayList<Log> logs = LogRepo.getByUser(ctx.pathParam("userUid"));
            ctx.json(Response.general(logs));
        });

        app.get("/api/admin/:uid/user/:userUid/app", ctx -> {
            ArrayList<App> logs = AppRepo.getByUser(ctx.pathParam("userUid"));
            ctx.json(Response.general(logs));
        });

        app.get("/api/admin/:adminuid/user/:useruid", ctx -> {
            User user = AccountRepo.getUserByUid(ctx.pathParam("useruid"));
            ctx.json(Response.general(user));
        });

        app.get("/api/admin/:adminuid/user/:useruid/coworkers", ctx -> {
            ArrayList<User> user = AccountRepo.getAllCoworkers(ctx.pathParam("useruid"));
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
            String limit = ctx.queryParam("limit");
            ArrayList<Log> logs;
            if (limit != null) logs = LogRepo.getInternalLogsWithLimit(limit);
            else logs = LogRepo.getInternalLogs();
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

        app.get("/api/admin/:uid/node/:nodeUid/log", ctx -> {
            ArrayList<Log> nodes = LogRepo.getByNode(ctx.pathParam("nodeUid"));
            ctx.json(Response.general(nodes));
        });

        // POST & PUT ENDPOINTS //

        app.post("/api/admin/:adminUid/user/:userUid", ctx -> {
            User user = ctx.bodyAsClass(User.class);
            ctx.json(AccountRepo.add(user));
        });

        app.put("/api/admin/:adminUid/user/:userUid", ctx -> {
            User user = ctx.bodyAsClass(User.class);
            ctx.json(AccountRepo.update(user));
        });

        app.put("/api/admin/:adminUid/app/:appUid", ctx -> {
            App user = ctx.bodyAsClass(App.class);
            ctx.json(AppRepo.update(user));
        });

    }
}
