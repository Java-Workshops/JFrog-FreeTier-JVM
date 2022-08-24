
package io.helidon.examples.quickstart.se;

import io.helidon.common.LogConfig;
import io.helidon.config.ClasspathConfigSource;
import io.helidon.config.Config;
import io.helidon.health.HealthSupport;
import io.helidon.health.checks.HealthChecks;
import io.helidon.media.jsonp.JsonpSupport;
import io.helidon.metrics.MetricsSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;

import java.util.concurrent.TimeUnit;

/**
 * Microstream demo with a simple rest application.
 */
public class Main {

  /**
   * Cannot be instantiated.
   */
  private Main() {
  }

  /**
   * Application main entry point.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    startServer();
  }

  static WebServer startServer() {

    LogConfig.configureRuntime();
    Config config = Config.builder()
                          .addSource(ClasspathConfigSource.create("/application.yaml"))
                          .build();

    // Build server with JSONP support
    WebServer server = WebServer.builder(createRouting(config))
                                .config(config.get("server"))
                                .addMediaSupport(JsonpSupport.create())
                                .build();

    // Try to start the server. If successful, print some info and arrange to
    // print a message at shutdown. If unsuccessful, print the exception.
    server.start()
          .thenAccept(ws -> {
            System.out.println(
                "WEB server is up! http://localhost:" + ws.port() + "/greet");
            ws.whenShutdown()
              .thenRun(()
                           -> System.out.println("WEB server is DOWN. Good bye!"));
          })
          .exceptionally(t -> {
            System.err.println("Startup failed: " + t.getMessage());
            t.printStackTrace(System.err);
            return null;
          })
          .await(10, TimeUnit.SECONDS);

    // Server threads are not daemon. No need to block. Just react.
    return server;
  }

  /**
   * Creates new {@link Routing}.
   *
   * @param config configuration of this server
   * @return routing configured with JSON support, a health check, and a service
   */
  private static Routing createRouting(Config config) {

    MetricsSupport metrics = MetricsSupport.create();
    HealthSupport health = HealthSupport.builder()
                                        .addLiveness(HealthChecks.healthChecks())   // Adds a convenient set of checks
                                        .build();

    GreetingService greetService = new GreetingService(config);

    return Routing.builder()
                  .register(health)                   // Health at "/health"
                  .register(metrics)                  // Metrics at "/metrics"
                  .register("/greet", greetService)
                  .build();
  }
}