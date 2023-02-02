package com.test.login;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ForgotPasswordOverlay {
    private final SelenideElement overlayTitle = $x("//h1[contains(text(), 'Forgot Password')]");
    private final SelenideElement sendButton = $x("//button[contains(text(), 'Send')]");
    private final SelenideElement validationMessage = $x("//*[contains(@class, 'input-error')]");
    private final SelenideElement emailField = $x("//input[@placeholder = 'Enter Email']");
    private final SelenideElement sendMeBackButton = $x("//*[contains(@class, 'modal__close-button')]");
    private final SelenideElement forgotPasswordPopup = $x("//*[contains(@class, 'auth-modal')]");
    private final SelenideElement successfulMessageHead = $x("//h1[contains(text(), 'Success')]");

    public boolean isOverlayTitleShown(){
        return overlayTitle.exists();
    }

    public boolean isSuccessfulMessageHeadShown(){
        return successfulMessageHead.exists();
    }

    public ForgotPasswordOverlay clickSendButton(){
        sendButton.click();
        sleep(2000);
        return this;
    }

    public String getValidationMessage(){
        return validationMessage.getText();
    }

    public ForgotPasswordOverlay setEmailField(String email){
        emailField.val(email);
        return this;
    }

    public String getEmailField(){
        return emailField.getText();
    }

    public LoginCabinetPage clickSendMeBackButton(){
        sendMeBackButton.click();
        sleep(3000);
        return new LoginCabinetPage();
    }

    public boolean isForgotPasswordPopupShown(){
        return forgotPasswordPopup.exists();
    }

}
