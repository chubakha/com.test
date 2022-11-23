package com.test.kanban.client_kanban;

import com.codeborne.selenide.SelenideElement;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;

import static com.codeborne.selenide.Selenide.$x;

public class NewOfferOverlay {
    private final SelenideElement createOfferButton = $x("//button[contains(text(), 'Create offer')]");

    public ManagerDetailOfferPage clickCreateOfferButton(){
        createOfferButton.click();
        return new ManagerDetailOfferPage();
    }


}
