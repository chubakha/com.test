package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.$x;

public class ClientCabinetPage {
    private SelenideElement taskRequestButton = $x("//button[contains(text(), 'task request')]");
    private SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");

    public boolean isTaskRequestButtonShown(){
        return taskRequestButton.shouldBe(Condition.enabled).isDisplayed();
    }

    public String getTaskRequestButtonText(){
        return taskRequestButton.getText();
    }

    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        return new LoginCabinetPage();
    }
}
