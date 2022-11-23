package com.test.login;

import com.codeborne.selenide.SelenideElement;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.onboarding.WelcomePopupOverlay;

import static com.codeborne.selenide.Selenide.*;

public class LoginCabinetPage {

    private final SelenideElement emailField = $x("//input[contains(@placeholder, 'Email')]");
    private final SelenideElement passwordField = $x("//input[contains(@placeholder, 'Password')]");
    private final SelenideElement sighInButton = $x("//button[contains(text(), 'SIGN IN')]");
    private final SelenideElement validationMessage = $x("//*[contains(@class, 'error-message')]");
    private final SelenideElement forgotPasswordLink = $x("//*[contains(text(), 'Forgot your password')]");
    private final SelenideElement pageTitle = $x("//h1[contains(text(), 'Sign in to access')]");
    private final SelenideElement forgotPasswordPopup = $x("//*[contains(@class, 'auth-modal')]");

    private void clickSighInButton(){
        sighInButton.click();
    }

    public ManagerKanbanPage loginAsManager() {
        clickSighInButton();
        return new ManagerKanbanPage();
    }

    public ClientKanbanPage loginAsClient() {
        clickSighInButton();
        return new ClientKanbanPage();
    }

    public WelcomePopupOverlay loginAsNewClient() {
        clickSighInButton();
        return new WelcomePopupOverlay();
    }

    public LoginCabinetPage clickInactiveSignUpButton() {
        clickSighInButton();
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

    public boolean isPageTitleShown(){
        return pageTitle.exists();
    }

}
