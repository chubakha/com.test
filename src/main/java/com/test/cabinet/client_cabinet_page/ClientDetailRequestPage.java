package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ClientDetailRequestPage {
    private final SelenideElement requestStatus = $x("//div[contains(@class, 'client_kanbanStep_notifications')]/span");

    public String getRequestStatus(){
        return requestStatus.getText();
    }


}
