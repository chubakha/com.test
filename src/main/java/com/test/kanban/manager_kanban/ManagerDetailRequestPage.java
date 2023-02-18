package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.kanban.client_kanban.NewOfferOverlay;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ManagerDetailRequestPage {
    private final SelenideElement turnIntoOfferButton = $x("//button[contains(text(), 'TURN INTO OFFER')]");
    private final SelenideElement editRequestLink = $x("//a[contains(text(), 'Edit')]");
    private final SelenideElement legalBoardLink = $x("//a[contains(text(), 'Legal Board')]");
    private final SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");

    public NewOfferOverlay clickTurnIntoOfferButton(){
        turnIntoOfferButton.click();
        sleep(3000);
        return new NewOfferOverlay();
    }

    public EditRequestOverlay clickEditRequestLink(){
        editRequestLink.click();
        sleep(3000);
        return new EditRequestOverlay();
    }

    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        sleep(2000);
        return new LoginCabinetPage();
    }

    public ManagerKanbanPage clickLegalBoardLink(){
        legalBoardLink.click();
        return new ManagerKanbanPage();
    }

}