import api.AdminEndpoints;
import api.WebEndpoints;
import db.Repository;
import io.javalin.Javalin;

import java.nio.file.Path;
import java.sql.SQLException;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Application {

    static WebEndpoints webEndpoints;
    static AdminEndpoints adminEndpoints;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Repository.init();

        Javalin app = Javalin.create()
                .start(7000);

        webEndpoints = new WebEndpoints(app);
        adminEndpoints = new AdminEndpoints(app);

        app.error(404, ctx -> {
            ctx.status(404);
        });
    }

}
