package com.test.admin_panel.onboarding_section;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ViewOnboardingPage {

    private final SelenideElement updateButton = $x("//a[contains(text(), 'Update')]");

    public boolean updateButtonIsShown(){
        return updateButton.exists();
    }
}
