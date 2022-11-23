package com.test.kanban.client_kanban;

import com.codeborne.selenide.SelenideElement;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.$x;

public class ClientDetailRequestPage {
    private final SelenideElement requestStatus = $x("//div[contains(@class, 'client_kanbanStep_notifications')]/span");
    private final SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");

    public String getRequestStatus(){
        return requestStatus.getText();
    }

    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        return new LoginCabinetPage();
    }


}