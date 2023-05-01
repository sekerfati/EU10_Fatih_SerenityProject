package B22.spartan.admin;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.http.*;
import net.serenitybdd.junit5.*;
import net.serenitybdd.rest.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.baseURI;

public class SpartanAdminGetTest {
    @BeforeAll
    public static void setUpBase() {

        baseURI = "http://44.200.16.230:7000";
    }

    @Test
    public void getAllSpartan(){
          given().accept(ContentType.JSON)
                  .and()
                  .auth().basic("admin", "admin")
                  .when()
                  .get("/api/spartans")
                  .then()
                  .statusCode(200)
                  .and()
                  .contentType(ContentType.JSON);

    }




}
