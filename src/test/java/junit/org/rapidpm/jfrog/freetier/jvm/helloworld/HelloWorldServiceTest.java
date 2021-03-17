package junit.org.rapidpm.jfrog.freetier.jvm.helloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rapidpm.jfrog.freetier.jvm.helloworld.HelloWorldService;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldServiceTest {

  @Test
  void toUpperCase() {
    String result = new HelloWorldService().toUpperCase("svenruppert.com");
    Assertions.assertEquals("SVENRUPPERT.COM", result);
  }
}