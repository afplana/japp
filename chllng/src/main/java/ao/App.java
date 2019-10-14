package ao;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

import java.util.logging.Logger;


public class App extends AbstractVerticle {
    private static Logger logger = Logger.getLogger(App.class.getName());

    Router router = Router.router(vertx);

    @Override
    public void start(Promise<Void> promise) {
        vertx
                .createHttpServer()
                .requestHandler(httpServerRequest ->
                        httpServerRequest.response().putHeader("content-type", "text/plain")
                                .end("<h1>Hello from my first " +
                                        "Vert.x 3 application</h1>")
                ).listen(8085, asyncResult -> {
            if (asyncResult.succeeded())
                promise.complete();
            else
                promise.fail(asyncResult.cause());
        });
    }
}
