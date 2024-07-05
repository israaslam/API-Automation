package payload;

public class User {

    String email;
    String role;
    String password;
    int otpCode;
    String passwordConfirm;
    String branchName;
    String streetName;
    int buildingNumber;
    String districtName;
    String city;
    int zipCode;
    boolean isAccessToDashboard;
    boolean isAccessToPos;

    public int getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(int otpCode) {
        this.otpCode = otpCode;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBranchName() {
        return branchName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isAccessToDashboard(boolean b) {
        return isAccessToDashboard;
    }

    public void setAccessToDashboard(boolean accessToDashboard) {
        isAccessToDashboard = accessToDashboard;
    }

    public boolean isAccessToPos(boolean b) {
        return isAccessToPos;
    }

    public void setAccessToPos(boolean accessToPos) {
        isAccessToPos = accessToPos;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", otpCode=" + otpCode + // Ensure to print the integer value
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
