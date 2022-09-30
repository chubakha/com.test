package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DetailRequestPage {
    private final SelenideElement requestStatus = $x("//div[contains(@class, 'client_kanbanStep_notifications')]/span");
    private final SelenideElement turnIntoOfferButton = $x("//button[contains(text(), 'TURN INTO OFFER')]");

    public String getRequestStatus(){
        return requestStatus.getText();
    }

    public NewOfferOverlay clickTurnIntoOfferButton(){
        turnIntoOfferButton.click();
        return new NewOfferOverlay();
    }

}
