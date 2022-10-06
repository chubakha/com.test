package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.SelenideElement;
import com.test.cabinet.manager_cabinet_page.ManagerDetailOfferPage;

import static com.codeborne.selenide.Selenide.$x;

public class NewOfferOverlay {
    private final SelenideElement createOfferButton = $x("//button[contains(text(), 'Create offer')]");

    public ManagerDetailOfferPage clickCreateOfferButton(){
        createOfferButton.click();
        return new ManagerDetailOfferPage();
    }


}
