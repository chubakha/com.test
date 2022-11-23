package com.test.onboarding;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HelloSignEmailPopupOverlay {

    private final SelenideElement emailField = $x("//input[contains(@id, 'email')]");
    private final SelenideElement verifyEmailField = $x("//span[contains(text(), 'Verify your email address')]");

    public HelloSignEmailPopupOverlay setEmailField(String email){
        emailField.val(email);
        return this;
    }

    public HelloSignEmailPopupOverlay clickVerifyEmailField(){
        verifyEmailField.click();
        return this;
    }
}
