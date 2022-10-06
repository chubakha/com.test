package com.test.cabinet.manager_cabinet_page;

import com.codeborne.selenide.SelenideElement;
import com.test.cabinet.client_cabinet_page.NewOfferOverlay;

import static com.codeborne.selenide.Selenide.$x;

public class ManagerDetailRequestPage {
    private final SelenideElement turnIntoOfferButton = $x("//button[contains(text(), 'TURN INTO OFFER')]");

    public NewOfferOverlay clickTurnIntoOfferButton(){
        turnIntoOfferButton.click();
        return new NewOfferOverlay();
    }

}
