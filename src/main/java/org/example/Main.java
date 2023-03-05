package org.example;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
    public static void main(String[] args) {

        var app = Javalin.create(javalinConfig -> {
            javalinConfig.staticFiles.add( staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/public";
                staticFileConfig.location = Location.CLASSPATH;
            });
        });

        app.start(7000);

        app.routes(() -> {
            app.get("/", ctx -> {
                ctx.result("Aplicacion 1");
            });
        });
    }
}