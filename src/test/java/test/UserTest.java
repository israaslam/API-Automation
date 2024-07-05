package test;

import com.github.javafaker.Faker;
import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import payload.User;


public class UserTest {
    Response response1;
    Response response2;
    Response createPassResponse;
    Response loginResponse;
    Response  storeResponse;
    private static String password;
    public static String globalToken;

    Faker faker;
    User userPayload;
/*
   @BeforeTest
    public void userTest(){

        token = globalToken

        String email = faker.internet().emailAddress();
        System.out.println("email is " +email);

        userPayload.setEmail(email);
        userPayload.setRole("CLIENT");
        userPayload.setPassword("Isra1234@");

    }

 */

    @Test
    public void test1() {

        faker = new Faker();
        userPayload = new User();
        String email = faker.internet().emailAddress();
        System.out.println("email is " + email);

        userPayload.setEmail(email);
        userPayload.setRole("CLIENT");
        password = "Isra1234@";
        userPayload.setPassword(password);

        response1 = UserEndPoints.CreateUser(userPayload);
        response1.then().log().all();
        Assert.assertEquals(response1.getStatusCode(), 201);

    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() {

        String getOTP = response1.jsonPath().getString("data.user.otpCode");
        System.out.println(" OTP is " + getOTP);

        String getEmail = response1.jsonPath().getString("data.user.email");
        System.out.println(" Email is " + getEmail);

        userPayload.setOtpCode(Integer.parseInt(getOTP));
        userPayload.setEmail(getEmail);

        System.out.println(" User Payload: " + userPayload);

        response2 = UserEndPoints.VerifyOTP(userPayload);
        response2.then().log().all();
        Assert.assertEquals(response2.getStatusCode(), 201);

    }

    @Test(dependsOnMethods = {"test1"})
    public void createPassword() {
        String getEmail = response1.jsonPath().getString("data.user.email");
        System.out.println(" Email is " + getEmail);

        userPayload.setPassword(password);
        userPayload.setPasswordConfirm(password);
        userPayload.setEmail(getEmail);

        createPassResponse = UserEndPoints.createpassword(userPayload);
        createPassResponse.then().log().all();
        Assert.assertEquals(createPassResponse.getStatusCode(), 201);

        globalToken = createPassResponse.jsonPath().getString("data.token");
        System.out.println("Token is " + globalToken);
    }

    @Test
    public void login() {

        String getEmail = response1.jsonPath().getString("data.user.email");
        System.out.println(" Email is " + getEmail);

        userPayload.setEmail(getEmail);
        userPayload.setPassword(password);

        loginResponse = UserEndPoints.loginUser(userPayload);
        loginResponse.then().log().all();
        Assert.assertEquals(loginResponse.getStatusCode(), 201);
    }

    @Test(dependsOnMethods = {"createPassword"})
    public void store(){


        userPayload.setBranchName("Khobar");
        userPayload.setStreetName("Block 8, House 837F");
        userPayload.setBuildingNumber(1234);
        userPayload.setDistrictName("Saudia");
        userPayload.setCity("Lahore");
        userPayload.setZipCode(78893);
        userPayload.isAccessToDashboard(true);
        userPayload.isAccessToPos(true);

       storeResponse = UserEndPoints.create_store(userPayload);
        System.out.println(storeResponse);
       storeResponse.then().log().all();
       Assert.assertEquals(storeResponse.getStatusCode(), 201);




    }





}

