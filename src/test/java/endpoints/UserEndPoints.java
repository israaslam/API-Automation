package endpoints;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;
import test.UserTest;

public class UserEndPoints {

    public static Response CreateUser(User payload) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(Routes.postNewUser);
        System.out.println(response.body());
        return response;
    }

    public static Response VerifyOTP(User payload) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)

                .body(payload)

                .when()
                .post(Routes.verifyOTP);

    }

    public static Response createpassword(User payload) {

     return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)

                .body(payload)

                .when()
                .post(Routes.createPassword);
    }

   public static Response loginUser(User payload){

        return given()
            //    .header("Authorization", "Bearer" +UserTest.globalToken)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .log().headers()
                .when()
                .post(Routes.loginWithEmail);
                }

   public static Response create_store(User payload){
        return given()

                .header("Authorization", "Bearer " +UserTest.globalToken)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .log().headers()
                .when()
                .post(Routes.createStore);
   }
}




