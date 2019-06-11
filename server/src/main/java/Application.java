import api.AdminEndpoints;
import api.ClientEndpoints;
import api.WebEndpoints;
import db.Repository;
import io.javalin.Javalin;
import models.Response;

import java.sql.SQLException;

public class Application {

    static WebEndpoints webEndpoints;
    static AdminEndpoints adminEndpoints;
    static ClientEndpoints clientEndpoints;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Repository.init();

        Javalin app = Javalin.create()
                .enableCorsForOrigin("localhost")
                .enableCorsForAllOrigins()
                .enableCaseSensitiveUrls()
                .start(7000);

        app.exception(Exception.class, (e, ctx) -> {
            ctx.json(Response.notFound(e.getMessage()));
        });

        webEndpoints = new WebEndpoints(app);
        adminEndpoints = new AdminEndpoints(app);
        clientEndpoints = new ClientEndpoints(app);

        app.error(404, ctx -> {
            ctx.json(Response.notFound("Path not found"));
        });
    }

}
