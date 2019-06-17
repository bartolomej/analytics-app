package api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import io.javalin.Javalin;
import models.User;

public class AuthEndpoints {

    Javalin app;

    // LINKS
    // https://javalin.io/2018/09/11/javalin-jwt-example.html
    // https://github.com/auth0/java-jwt

    public AuthEndpoints(Javalin app) {
        this.app = app;
        this.routesHandler();
    }

    private void init() {

    }

    private void routesHandler() {
        // AUTH ROUTES
    }
}
