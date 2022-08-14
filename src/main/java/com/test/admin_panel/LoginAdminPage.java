package com.test.admin_panel;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginAdminPage {
    private final SelenideElement usernameField = $x("//input[contains(@placeholder, 'Username')]");
    private final SelenideElement passwordField = $x("//input[contains(@placeholder, 'Password')]");
    private final SelenideElement signInButton = $x("//button[contains(text(), 'Sign in')]");

    private void clickSignInButton(){
        signInButton.click();
    }

    public LoginAdminPage clickInactiveSignInButton(){
        signInButton.click();
        return this;
    }

    public MainAdminPage loginAsAdmin(){
        signInButton.click();
        return new MainAdminPage();
    }

    public LoginAdminPage setUsernameField(String username){
        usernameField.val(username);
        return this;
    }

    public LoginAdminPage setPasswordField(String password){
        passwordField.val(password);
        return this;
    }

}
