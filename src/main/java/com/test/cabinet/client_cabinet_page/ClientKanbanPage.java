package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.$x;

public class ClientKanbanPage {
    private final SelenideElement newRequestButton = $x("//button[contains(text(), 'NEW REQUEST')]");
    private final SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");

    public boolean isTaskRequestButtonShown(){
        return newRequestButton.shouldBe(Condition.enabled).isDisplayed();
    }

    public String getTaskRequestButtonText(){
        return newRequestButton.getText();
    }

    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        return new LoginCabinetPage();
    }

    public CreateTaskRequestOverlay clickNewRequestButton(){
        newRequestButton.click();
        return new CreateTaskRequestOverlay();
    }

    public ClientDetailRequestPage clickRequestCard(String title){
        $x("//*[contains(@class, 'body-title')and text() = '" + title + "']").click();
        return new ClientDetailRequestPage();
    }

    public ClientDetailOfferPage clickOfferCard(String title){
        $x("//*[contains(@class, 'body-title')and text() = '" + title + "']").click();
        return new ClientDetailOfferPage();
    }

}
