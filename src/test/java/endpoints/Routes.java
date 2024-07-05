package endpoints;

public class Routes {

    public static String baseURL = "https://staging-backend.tagdev.sa";

    public static String postNewUser = baseURL+ "/auth/sign-up-with-email";

    public static String verifyOTP = baseURL+ "/auth/verify-otp";

    public static String createPassword = baseURL+ "/auth/create-password";

    public static String loginWithEmail = baseURL+ "/auth/login-with-email";

    public static String createStore = baseURL+ "/stores";
}
