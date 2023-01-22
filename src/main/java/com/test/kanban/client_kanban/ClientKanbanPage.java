package com.test.kanban.client_kanban;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.test.login.LoginCabinetPage;
import com.test.setting.InvoicesListPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ClientKanbanPage {
    private final SelenideElement newRequestButton = $x("//button[contains(text(), 'NEW REQUEST')]");
    private final SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");
    private final SelenideElement amountOfRequest = $x("//*[contains(text(), 'New requests from client')]/following-sibling::span");
    private final SelenideElement amountOfNewOffers = $x("//*[contains(text(), 'New offers from VLO')]/following-sibling::span");
    private final SelenideElement amountOfTasksInProgress = $x("//*[contains(text(), 'Tasks in progress')]/following-sibling::span");
    private final SelenideElement amountOfTasksComplete = $x("//*[contains(text(), 'Tasks complete')]/following-sibling::span");
    private final SelenideElement legalBoardLink = $x("//a[contains(text(), 'Legal Board')]");
    private final SelenideElement billingLink = $x("//a[contains(text(), 'Billing')]");

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
        sleep(2000);
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

    public ClientKanbanPage clickLegalBoardLink(){
        legalBoardLink.click();
        return this;
    }

    public InvoicesListPage clickBillingLink(){
        sleep(2000);
        billingLink.click();
        return new InvoicesListPage();
    }

    public String getAmountOfRequest(){
        return amountOfRequest.getText();
    }

    public String getAmountOfNewOffers(){
        return amountOfNewOffers.getText();
    }

    public String getAmountOfTasksInProgress(){
        return amountOfTasksInProgress.getText();
    }

    public String getAmountOfTasksComplete(){
        return amountOfTasksComplete.getText();
    }

}
