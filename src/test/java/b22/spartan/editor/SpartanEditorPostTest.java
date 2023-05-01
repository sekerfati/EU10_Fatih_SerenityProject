package b22.spartan.editor;

import utilities.SpartanNewBase;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.*;
import net.serenitybdd.junit5.*;
import utilities.SpartanUtil;

import java.util.Map;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.baseURI;
import static net.serenitybdd.rest.SerenityRest.*;



@SerenityTest
public class SpartanEditorPostTest extends SpartanNewBase {

    @DisplayName("Editor should be able to POST")
    @Test
    public void postSpartanAsEditor() {

        //when you need deserialize or serialize, you dont need to add separate dependency, it comes
        //with serenity
        //create one spartan using util
        Map<String, Object> bodyMap= SpartanUtil.getRandomSpartanMap();
        System.out.println("bodyMap = " + bodyMap);


        //send a post request as editor

     given()
             .auth().basic("editor", "editor")
             .accept(ContentType.JSON)
             .contentType(ContentType.JSON)
             .body(bodyMap)
             .log().all()
             .when()
             .post("/spartans")
             .prettyPrint();

    }


}
