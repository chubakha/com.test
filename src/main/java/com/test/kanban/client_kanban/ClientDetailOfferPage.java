package com.test.kanban.client_kanban;

import com.codeborne.selenide.SelenideElement;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.*;

public class ClientDetailOfferPage {
    private final SelenideElement legalBoardLink = $x("//a[contains(text(), 'Legal Board')]");
    private final SelenideElement acceptButton = $x("//button[contains(text(), 'Accept')]");
    private final SelenideElement statusOfferText = $x("//*[contains(@class, 'client_kanbanStep_notifications__info')]/span");
    private final SelenideElement commentFieldIframe = $x("//*[contains(@id, 'tiny-react') and contains(@id, 'ifr')]");
    private final SelenideElement commentField = $x("//*[contains(@id, 'tinymce')]/p");
    private final SelenideElement sendCommentButton = $x("//button[contains(@class, 'send-button')]");
    private final SelenideElement lastChatMessageAuthor = $x("//div[@class='user-messages'][1]//div[contains(@class, 'user-messages__avatar')]/div[2]/p/b");
    private final SelenideElement lastChatMessageDate = $x("//div[@class='user-messages'][1]//div[contains(@class, 'user-messages__sending-time')]/span/em[1]");
    private final SelenideElement lastChatMessageText = $x("//div[@class='user-messages'][1]//div[contains(@class, 'task-body__description-block')]/p/p[1]");
    private final SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");
    private final SelenideElement editMessageIcon = $x("//div[contains(@class, 'messages')][1]/div[contains(@class, 'sending-time')]/*[contains(@class, 'messages__edit')]");
    private final SelenideElement editMessagePopup = $x("//div[contains(@class, 'messages')][1]/div[contains(@class, 'sending-time')]/div[contains(@class, 'messages__edit')]/div[contains(@class, 'edit-dropdown')]");
    private final SelenideElement header = $x("//div[@class='header__left']");

    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        return new LoginCabinetPage();
    }

    public ClientKanbanPage clickLegalBoardLink(){
        legalBoardLink.click();
        return new ClientKanbanPage();
    }

    public ClientDetailOfferPage clickAcceptButton(){
        acceptButton.click();
        sleep(4000);
        return new ClientDetailOfferPage();
    }

    public boolean isAcceptButtonEnabled(){
        return acceptButton.isEnabled();
    }

    public String getStatusOfferText(){
        sleep(2000);
        return statusOfferText.getText();
    }

    public ClientDetailOfferPage scrollToUpPage(){
        header.scrollIntoView(false);
        return this;
    }

    public ClientDetailOfferPage setCommentField(String value){
        commentField.val(value);
        return this;
    }

    public ClientDetailOfferPage editCommentField(String value){
        commentField.append(value);
        return this;
    }

    public ClientDetailOfferPage clickSendCommentButton(){
        sendCommentButton.click();
        sleep(3000);
        return this;
    }

    public ClientDetailOfferPage switchToChatIframe(){
        switchTo().frame(commentFieldIframe);
        return this;
    }

    public ClientDetailOfferPage switchToRootContainerPage(){
        switchTo().parentFrame();
        return this;
    }

    public String getLastChatMessageAuthor(){
        return lastChatMessageAuthor.getText();
    }

    public String getLastChatMessageDate(){
        return lastChatMessageDate.getText();
    }

    public String getLastChatMessageText(){
        return lastChatMessageText.getText();
    }

    public ClientDetailOfferPage clickLastChatMessageText(){
        lastChatMessageText.click();
        return this;
    }

    public EditMessageOverlay hoverEditMessageIcon(){
        editMessageIcon.hover();
        return new EditMessageOverlay();
    }






}
