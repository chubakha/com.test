package com.test.login;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ForgotPasswordOverlay {
    private SelenideElement overlayTitle = $x("//h1[contains(text(), 'Forgot Password')]");
    private SelenideElement sendButton = $x("//button[contains(text(), 'Send')]");
    private SelenideElement validationMessage = $x("//*[contains(@class, 'input-error')]");
    private SelenideElement emailField = $x("//input[@placeholder = 'Enter Email']");
    private SelenideElement sendMeBackButton = $x("//*[contains(@class, 'modal__close-button')]");
    private SelenideElement forgotPasswordPopup = $x("//*[contains(@class, 'auth-modal')]");

    public String getOverlayTitle(){
        return overlayTitle.getText();
    }

    public ForgotPasswordOverlay clickSendButton(){
        sendButton.click();
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

    public ClientLoginPage clickSendMeBackButton(){
        sendMeBackButton.click();
        return new ClientLoginPage();
    }

    public boolean isForgotPasswordPopupShown(){
        return forgotPasswordPopup.exists();
    }

}
