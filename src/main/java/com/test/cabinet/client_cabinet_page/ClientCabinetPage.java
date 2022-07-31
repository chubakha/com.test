package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ClientCabinetPage {
    private SelenideElement taskRequestButton = $x("//button[contains(text(), 'task request')]");

    public boolean isTaskRequestButtonShown(){
        return taskRequestButton.isDisplayed();
    }

    public String getTaskRequestButtonText(){
        return taskRequestButton.getText();
    }
}
