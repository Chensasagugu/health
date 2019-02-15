package hdu.cn.hziee.model;

public class Consumer {
    private Integer userId;

    private String user;

    private String password;

    private String userName;

    private String userSex;

    private Integer userAge;

    private Double userHeight;

    private Double userWeight;

    private Integer userWorkpressure;

    private String userFaceToken;

    private Integer userSpecial;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Double getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(Double userHeight) {
        this.userHeight = userHeight;
    }

    public Double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Double userWeight) {
        this.userWeight = userWeight;
    }

    public Integer getUserWorkpressure() {
        return userWorkpressure;
    }

    public void setUserWorkpressure(Integer userWorkpressure) {
        this.userWorkpressure = userWorkpressure;
    }

    public String getUserFaceToken() {
        return userFaceToken;
    }

    public void setUserFaceToken(String userFaceToken) {
        this.userFaceToken = userFaceToken == null ? null : userFaceToken.trim();
    }

    public Integer getUserSpecial() {
        return userSpecial;
    }

    public void setUserSpecial(Integer userSpecial) {
        this.userSpecial = userSpecial;
    }
}