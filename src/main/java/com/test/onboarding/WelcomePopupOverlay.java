package com.test.onboarding;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WelcomePopupOverlay {
    private SelenideElement popup = $x("//*[@class = 'modal__container']");

    public boolean isPopupShown(){
        return popup.exists();
    }
}
