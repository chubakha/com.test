package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EditMessageOverlay {

    private final SelenideElement editMessageLink = $x("//div[contains(@class, 'messages')][1]/div[contains(@class, 'sending-time')]/div[contains(@class, 'messages__edit')]/div[contains(@class, 'edit-dropdown')]/div[contains(text(), 'Edit')]");
    private final SelenideElement deleteMessageLink = $x("//div[contains(@class, 'messages')][1]/div[contains(@class, 'sending-time')]/div[contains(@class, 'messages__edit')]/div[contains(@class, 'edit-dropdown')]/div[contains(text(), 'Delete')]");
    private final SelenideElement editMessagePopup = $x("//div[contains(@class, 'messages')][1]/div[contains(@class, 'sending-time')]/div[contains(@class, 'messages__edit')]/div[contains(@class, 'edit-dropdown')]");

    public boolean isEditMessagePopupShown(){
        return editMessagePopup.isDisplayed();
    }

    public ManagerDetailOfferPage clickEditMessageLink(){
        editMessageLink.click();
        return new ManagerDetailOfferPage();
    }

    public ManagerDetailOfferPage clickDeleteMessageLink(){
        deleteMessageLink.click();
        return new ManagerDetailOfferPage();
    }

}
