package io.helidon.examples.quickstart.se;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import io.helidon.media.jsonp.JsonpSupport;
import io.helidon.webclient.WebClient;
import io.helidon.webserver.WebServer;

//import jakarta.json.JsonArray;
//import jakarta.json.JsonObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class MicrostreamExampleGreetingsSeTest {

  private static WebServer webServer;
  private static WebClient webClient;

  @TempDir
  static Path tempDir;

  @BeforeAll
  static void startServer() throws Exception {
    System.setProperty("microstream.storage-directory", tempDir.toString());

    webServer = Main.startServer();

    webClient = WebClient.builder().baseUri("http://localhost:" + webServer.port())
                         .addMediaSupport(JsonpSupport.create()).build();
  }

  @AfterAll
  static void stopServer() throws Exception {
    if (webServer != null) {
      webServer.shutdown().await(10, TimeUnit.SECONDS);
    }
  }

  @Test
  void testExample() {
    JsonObject jsonObject = webClient
        .get()
        .path("/greet/Joe")
        .request(JsonObject.class)
        .await(10, TimeUnit.SECONDS);

    Assertions.assertEquals("Hello Joe!", jsonObject.getString("message"));

    JsonArray jsonArray = webClient
        .get()
        .path("/greet/logs")
        .request(JsonArray.class)
        .await(10, TimeUnit.SECONDS);

    Assertions.assertEquals("Joe", jsonArray.get(0).asJsonObject().getString("name"));
    Assertions.assertNotNull(jsonArray.get(0).asJsonObject().getString("time"));
  }
}


