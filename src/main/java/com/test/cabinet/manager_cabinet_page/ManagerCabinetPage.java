package com.test.cabinet.manager_cabinet_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ManagerCabinetPage {
    private SelenideElement newOfferButton = $x("//button[contains(text(), 'NEW OFFER')]");

    public boolean isNewOfferButtonShown(){
        return newOfferButton.isDisplayed();
    }

    public String getNewOfferButtonText(){
        return newOfferButton.getText();
    }

}
