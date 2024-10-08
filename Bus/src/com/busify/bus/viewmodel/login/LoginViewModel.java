package com.busify.bus.viewmodel.login;

public class LoginViewModel {
    private LoginScreen loginScreen;
    public LoginViewModel(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }
    private String userName = "prasanth";

    private String userPassword = "duke200bs6";
     boolean validateUser(String userName, String password) {
        if (this.userName.equals(userName) && this.userPassword.equals(password)) {

        } else {
            loginScreen.showErrorMessage("Invalid User name or Password");
        }
        return false;
    }
}
