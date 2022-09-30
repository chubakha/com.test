package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NewOfferOverlay {
    private final SelenideElement createOfferButton = $x("//button[contains(text(), 'Create offer')]");
    private final SelenideElement legalBoardLink = $x("//a[contains(text(), 'Legal Board");

    public DetailOfferPage clickCreateOfferButton(){
        createOfferButton.click();
        return new DetailOfferPage();
    }

    public ClientCabinetPage clickLegalBoardLink(){
        legalBoardLink.click();
        return new ClientCabinetPage();
    }
}
