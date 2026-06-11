package ru.netology.ru;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void testPostRequestWithLatinText() {
        String requestBody = "some data";

        given()
                .baseUri("https://postman-echo.com")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

    @Test
    void testPostRequestWithRussianText() {
        String requestBody = "Привет, мир!";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

}