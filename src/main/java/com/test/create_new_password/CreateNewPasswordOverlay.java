package com.test.create_new_password;

import com.codeborne.selenide.SelenideElement;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateNewPasswordOverlay {

    private final SelenideElement overlayTitle = $x("//h1[contains(text(), 'Reset Password')]");
    private final SelenideElement passwordHaveBeenSavedTitle = $x("//h1[contains(text(), 'Password have been saved')]");
    private final SelenideElement passwordField = $x("//input[@placeholder = 'New Password']");
    private final SelenideElement retypePasswordField = $x("//input[@placeholder = 'Retype Password']");
    private final SelenideElement sendButton = $x("//button[contains(text(), 'Send')]");
    private final SelenideElement closeButton = $x("//button[contains(text(), 'Close')]");
    private final SelenideElement cancelLink = $x("//*[contains(text(), 'Cancel')]");

    public String getOverlayTitle(){
        return overlayTitle.getText();
    }

    public String getPasswordHaveBeenSavedTitle(){
        return passwordHaveBeenSavedTitle.getText();
    }

    public CreateNewPasswordOverlay setPasswordField(String password){
        passwordField.val(password);
        return this;
    }

    public CreateNewPasswordOverlay setRetypePasswordField(String password){
        retypePasswordField.val(password);
        return this;
    }

    public CreateNewPasswordOverlay clickSendButton(){
        sendButton.click();
        return this;
    }

    public LoginCabinetPage clickCloseButton(){
        closeButton.click();
        sleep(1000);
        return new LoginCabinetPage();
    }

    public LoginCabinetPage clickSendMeBackLink(){
        cancelLink.click();
        sleep(2000);
        return new LoginCabinetPage();
    }


}
