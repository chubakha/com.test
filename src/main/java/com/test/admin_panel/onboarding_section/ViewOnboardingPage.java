package com.test.admin_panel.onboarding_section;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ViewOnboardingPage {

    private final SelenideElement updateButton = $x("//a[contains(text(), 'Update')]");

    public boolean updateButtonIsShown(){
        sleep(500);
        return updateButton.exists();
    }
}
