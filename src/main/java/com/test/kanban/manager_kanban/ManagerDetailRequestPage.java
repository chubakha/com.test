package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;
import com.test.kanban.client_kanban.NewOfferOverlay;

import static com.codeborne.selenide.Selenide.$x;

public class ManagerDetailRequestPage {
    private final SelenideElement turnIntoOfferButton = $x("//button[contains(text(), 'TURN INTO OFFER')]");

    public NewOfferOverlay clickTurnIntoOfferButton(){
        turnIntoOfferButton.click();
        return new NewOfferOverlay();
    }

}
