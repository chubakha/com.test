package com.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement emailField = $("[placeholder='Email ']");
    private SelenideElement passwordField = $("[placeholder='Password']");
    private SelenideElement loginButton = $(".login-page__btn");

    public ManagerCabinetPage loginAsUserByManager(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLoginButton();
        return new ManagerCabinetPage();
    }

    public ProviderCabinetPage loginAsUserByProvider(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLoginButton();
        return new ProviderCabinetPage();
    }

    public ClientCabinetPage loginAsUserByClient(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLoginButton();
        return new ClientCabinetPage();
    }

    public LoginPage setEmailField(String email){
        emailField.val(email);
        return this;
    }

    public LoginPage setPasswordField(String password){
        passwordField.val(password);
        return this;
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getEmailField(){
        return emailField.getText();
    }

    public String getPasswordField(){
        return passwordField.getText();
    }
}
