package api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import db.UserRepo;
import io.javalin.Javalin;
import models.User;

import java.util.ArrayList;
import java.util.Date;

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
