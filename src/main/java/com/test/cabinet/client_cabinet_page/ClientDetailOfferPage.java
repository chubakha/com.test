package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ClientDetailOfferPage {
    private final SelenideElement legalBoardLink = $x("//a[contains(text(), 'Legal Board')]");
    private final SelenideElement acceptButton = $x("//button[contains(text(), 'Accept')]");
    private final SelenideElement statusOfferText = $x("//*[contains(@class, 'client_kanbanStep_notifications__info')]/span");

    public ClientKanbanPage clickLegalBoardLink(){
        legalBoardLink.click();
        return new ClientKanbanPage();
    }

    public ClientDetailOfferPage clickAcceptButton(){
        acceptButton.click();
        return new ClientDetailOfferPage();
    }

    public boolean isAcceptButtonEnabled(){
        return acceptButton.isEnabled();
    }

    public String getStatusOfferText(){
            return statusOfferText.getText();
    }

}
