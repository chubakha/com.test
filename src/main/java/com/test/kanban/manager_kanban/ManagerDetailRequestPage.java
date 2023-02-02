package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;
import com.test.kanban.client_kanban.NewOfferOverlay;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ManagerDetailRequestPage {
    private final SelenideElement turnIntoOfferButton = $x("//button[contains(text(), 'TURN INTO OFFER')]");

    public NewOfferOverlay clickTurnIntoOfferButton(){
        turnIntoOfferButton.click();
        sleep(3000);
        return new NewOfferOverlay();
    }

}
