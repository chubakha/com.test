package com.test.registration.fourth_registration_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ConfirmYourAccountOverlay {
    private SelenideElement confirmYourAccountTitle = $x("//h1[contains(@class, 'FinishStep_container_heading')]");

    public String getPageTitle(){
        return confirmYourAccountTitle.getText();
    }
}
