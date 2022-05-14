package com.test.login;

import com.codeborne.selenide.SelenideElement;
import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import com.test.cabinet.manager_cabinet_page.ManagerCabinetPage;

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
