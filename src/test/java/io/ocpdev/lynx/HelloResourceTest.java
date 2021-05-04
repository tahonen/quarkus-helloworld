package io.ocpdev.lynx;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.eclipse.microprofile.config.inject.*;
import org.junit.jupiter.api.*;

import io.quarkus.test.junit.*;

@QuarkusTest
public class HelloResourceTest {
    @ConfigProperty(name = "environment", defaultValue="local")
    String environment;
    @ConfigProperty(name = "name", defaultValue="me")
    String name;
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello "+name+" in "+environment));
    }

}