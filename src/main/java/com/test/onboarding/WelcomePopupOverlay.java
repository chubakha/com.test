package com.test.onboarding;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WelcomePopupOverlay {
    private final SelenideElement popup = $x("//*[@class = 'modal__container']");
    private final SelenideElement continueButton = $x("//button[text() = 'CONTINUE']");

    public boolean isPopupShown(){
        return popup.exists();
    }

    public OnboardingPage clickContinueButton(){
        continueButton.click();
        return new OnboardingPage();
    }


}
