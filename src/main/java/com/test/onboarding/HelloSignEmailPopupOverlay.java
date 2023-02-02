package com.test.onboarding;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class HelloSignEmailPopupOverlay {

    private final SelenideElement emailField = $x("//input[contains(@id, 'email')]");
    private final SelenideElement verifyEmailField = $x("//button[contains(@type, 'submit')]");

    public HelloSignEmailPopupOverlay setEmailField(String email){
        emailField.val(email);
        return this;
    }

    public HelloSignEmailPopupOverlay clickVerifyEmailField(){
        verifyEmailField.click();
        sleep(5000);
        return this;
    }
}
