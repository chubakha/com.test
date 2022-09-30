package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DetailOfferPage {
    private final SelenideElement offerStatus = $x("//div[contains(@class, 'client_kanbanStep_notifications')]/span");

    public String getOfferStatus(){
        return offerStatus.getText();
    }

}
