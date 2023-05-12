package b22.spartan.admin;

import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.*;
import net.serenitybdd.junit5.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.baseURI;
import static net.serenitybdd.rest.SerenityRest.*;

@SerenityTest

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



    @Test
    public void getOneSpartan(){
                given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin", "admin")
                .pathParam("id", 15)
                .when()
                .get("/api/spartans/{id}");

        //if you send a request using SerenityRest, the response object
        //can be obtained from the method called lastResponse() without being saved separately
        //same with Response response object

        System.out.println("status Code() = " + lastResponse().statusCode());

        //print id
        //instead of response.path, we use lastResponse.path()
        System.out.println("lastResponse().path(\"id\") = " + lastResponse().path("id"));


        //use jsonpath with lastResponse and get the name
        String name = lastResponse().jsonPath().getString("name");
        System.out.println("name = " + name);


    }



    @DisplayName("GET request with Serenity Assertion way")
    @Test
    public void getOneSpartanAssertion(){

        given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin", "admin")
                .pathParam("id", 15)
                .when()
                .get("/api/spartans/{id}");

        //Serenity way of assertion
      Ensure.that("Status code is 200", validatableResponse -> validatableResponse.statusCode(200));

      Ensure.that("Content type is JSON", vR -> vR.contentType(ContentType.JSON));

      Ensure.that("Id is 15", vR -> vR.body("id", is(15)));




    }




}
