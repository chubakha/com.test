package com.test.login;

import com.codeborne.selenide.SelenideElement;
import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import com.test.cabinet.manager_cabinet_page.ManagerCabinetPage;
import com.test.onboarding.WelcomePopupOverlay;

import static com.codeborne.selenide.Selenide.*;

public class LoginCabinetPage {

    private SelenideElement emailField = $x("//input[contains(@placeholder, 'Email')]");
    private SelenideElement passwordField = $x("//input[contains(@placeholder, 'Password')]");
    private SelenideElement loginButton = $x("//button[contains(text(), 'SIGN IN')]");
    private SelenideElement validationMessage = $x("//*[contains(@class, 'error-message')]");
    private SelenideElement forgotPasswordLink = $x("//*[contains(text(), 'Forgot Password')]");
    private SelenideElement pageTitle = $x("//h1[contains(text(), 'Sign in to access')]");
    private SelenideElement forgotPasswordPopup = $x("//*[contains(@class, 'auth-modal')]");

    public void clickLoginButton(){
        loginButton.click();
    }

    public ManagerCabinetPage loginAsManager() {
        clickLoginButton();
        return new ManagerCabinetPage();
    }

    public ClientCabinetPage loginAsClient() {
        clickLoginButton();
        return new ClientCabinetPage();
    }

    public WelcomePopupOverlay loginAsNewClient() {
        clickLoginButton();
        return new WelcomePopupOverlay();
    }

    public LoginCabinetPage clickInactiveSignUpButton() {
        clickLoginButton();
        return this;
    }

    public LoginCabinetPage setEmailField(String email){
        emailField.val(email);
        return this;
    }

    public LoginCabinetPage setPasswordField(String password){
        passwordField.val(password);
        return this;
    }

    public String getEmailField(){
        return emailField.getText();
    }

    public String getPasswordField(){
        return passwordField.getText();
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public ForgotPasswordOverlay clickForgotPasswordLink(){
        forgotPasswordLink.click();
        return new ForgotPasswordOverlay();
    }

    public String getValidationMessage(){
        return validationMessage.getText();
    }

    public boolean isForgotPasswordPopupShown(){
        return forgotPasswordPopup.exists();
    }

}
