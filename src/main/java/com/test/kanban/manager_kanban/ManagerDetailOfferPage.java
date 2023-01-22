package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.*;

public class ManagerDetailOfferPage {
    private final SelenideElement publishButton = $x("//button[contains(text(), 'PUBLISH')]");
    private final SelenideElement moveToNextStatusButton = $x("//button[contains(@class, 'offerHeader__button')]");
    private final SelenideElement statusesDropDown = $x("//div[@class = 'task-status']");
    private final SelenideElement moveToPaymentStatus = $x("//div[@class='task-status__body-item' and contains(text(), 'MOVE TO PAYMENT')]");
    private final SelenideElement startDeliveryStatus = $x("//div[@class='task-status__body-item' and contains(text(), 'START DELIVERY')]");
    private final SelenideElement moveToDoneStatus = $x("//div[@class='task-status__body-item' and contains(text(), 'MOVE TO DONE')]");
    private final SelenideElement nextStepText = $x("//span[@class='offerHeading__steps-step']");
    private final SelenideElement offerStatusText = $x("//div[@class='offerHeader__status']");
    private final SelenideElement commentFieldIframe = $x("//*[contains(@id, 'tiny-react') and contains(@id, 'ifr')]");
    private final SelenideElement commentField = $x("//*[contains(@id, 'tinymce')]/p");
    private final SelenideElement sendCommentButton = $x("//button[contains(@class, 'send-button')]");
    private final SelenideElement lastChatMessageAuthor = $x("//div[@class='user-messages'][1]//div[contains(@class, 'user-messages__avatar')]/div[2]/p/b");
    private final SelenideElement lastChatMessageDate = $x("//div[@class='user-messages'][1]//div[contains(@class, 'user-messages__sending-time')]/span/em[1]");
    private final SelenideElement lastChatMessageText = $x("//div[@class='user-messages'][1]//div[contains(@class, 'task-body__description-block')]/p/p[1]");
    private final SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");
    private final SelenideElement editMessageIcon = $x("//div[contains(@class, 'messages')][1]/div[contains(@class, 'sending-time')]/*[contains(@class, 'messages__edit')]");
    private final SelenideElement editMessagePopup = $x("//div[contains(@class, 'messages')][1]/div[contains(@class, 'sending-time')]/div[contains(@class, 'messages__edit')]/div[contains(@class, 'edit-dropdown')]");


    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        return new LoginCabinetPage();
    }

    public ManagerDetailOfferPage clickPublishButton(){
        publishButton.click();
        return this;
    }

    public String getMoveToNextStatusButton(){
        return moveToNextStatusButton.getText();
    }

    public ManagerDetailOfferPage clickStatusesDropDown(){
        statusesDropDown.click();
        return this;
    }

    public ManagerDetailOfferPage clickMoveToPaymentStatus(){
        moveToPaymentStatus.click();
        return this;
    }

    public ManagerDetailOfferPage clickStartDeliveryStatus(){
        startDeliveryStatus.click();
        return this;
    }

    public ManagerDetailOfferPage clickMoveToDoneStatus(){
        moveToDoneStatus.click();
        return this;
    }

    public String getNextStepText(){
        sleep(3000);
        return nextStepText.getText();
    }

    public String getOfferStatusText(){
        sleep(3000);
        return offerStatusText.getText();
    }

    public ManagerDetailOfferPage setCommentField(String value){
        commentField.val(value);
        return this;
    }

    public ManagerDetailOfferPage editCommentField(String value){
        commentField.append(value);
        return this;
    }

    public ManagerDetailOfferPage clickSendCommentButton(){
        sendCommentButton.click();
        return this;
    }

    public ManagerDetailOfferPage switchToChatIframe(){
        switchTo().frame(commentFieldIframe);
        return this;
    }

    public ManagerDetailOfferPage switchToRootContainerPage(){
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

    public ManagerDetailOfferPage clickLastChatMessageText(){
        lastChatMessageText.click();
        return this;
    }

    public EditMessageOverlay hoverEditMessageIcon(){
        editMessageIcon.hover();
        return new EditMessageOverlay();
    }

}
