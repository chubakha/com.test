package com.test.cabinet.manager_cabinet_page;

import com.codeborne.selenide.SelenideElement;
import com.test.cabinet.client_cabinet_page.ClientDetailOfferPage;
import com.test.cabinet.client_cabinet_page.ClientDetailRequestPage;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.$x;

public class ManagerKanbanPage {
    private final SelenideElement newOfferButton = $x("//button[contains(text(), 'NEW OFFER')]");
    private final SelenideElement newClientButton = $x("//button[contains(text(), 'New client')]");
    private final SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");
    private final SelenideElement selectedCompany = $x("//div[contains(@class, 'mobile__current')]/div[1]");
    private final SelenideElement companyListDropdown = $x("//div[contains(@class, 'kanban-dropdown')]/div[1]");
    private final SelenideElement amountOfRequest = $x("//*[contains(text(), 'New requests from client')]/following-sibling::span");
    private final SelenideElement amountOfNewOffers = $x("//*[contains(text(), 'New offers from VLO')]/following-sibling::span");
    private final SelenideElement amountOfTasksInProgress = $x("//*[contains(text(), 'Tasks in progress')]/following-sibling::span");
    private final SelenideElement amountOfTasksComplete = $x("//*[contains(text(), 'Tasks complete')]/following-sibling::span");


    public boolean isNewOfferButtonShown(){
        return newOfferButton.isDisplayed();
    }

    public String getNewOfferButtonText(){
        return newOfferButton.getText();
    }

    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        return new LoginCabinetPage();
    }

    public NewClientOverlay clickNewClientButton(){
        newClientButton.click();
        return new NewClientOverlay();
    }

    public String getSelectedCompany(){
        return selectedCompany.getText();
    }

    public ManagerDetailRequestPage clickRequestCard(String title){
        $x("//*[contains(@class, 'body-title')and text() = '" + title + "']").click();
        return new ManagerDetailRequestPage();
    }

    public ManagerDetailOfferPage clickOfferCard(String title){
        $x("//*[contains(@class, 'body-title')and text() = '" + title + "']").click();
        return new ManagerDetailOfferPage();
    }

    public ManagerKanbanPage clickCompanyListDropdown(){
        companyListDropdown.click();
        return this;
    }

    public ManagerKanbanPage clickCompanyInDropdown(String company){
        $x("//*[@title = '" + company + "']").click();
        return this;
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
