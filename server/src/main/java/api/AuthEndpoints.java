package api;

import io.javalin.Javalin;

public class AuthEndpoints {

    Javalin app;

    // LINKS
    // https://javalin.io/2018/09/11/javalin-jwt-example.html
    // https://github.com/auth0/java-jwt

    public AuthEndpoints(Javalin app) {
        this.app = app;
        this.routesHandler();
    }

    private void initializeAuth() {
        // INIT
    }

    private void routesHandler() {
        // AUTH ROUTES
    }
}
