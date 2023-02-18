package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.*;

public class ManagerDetailOfferPage {
    private final SelenideElement publishButton = $x("//button[contains(text(), 'PUBLISH')]");
    private final SelenideElement moveToNextStatusButton = $x("//button[contains(@class, 'offerHeader__button')]");
    private final SelenideElement statusesDropDown = $x("//div[@class = 'task-status']");
    private final SelenideElement moveToPaymentStatusButton = $x("//div[@class='task-status__body-item' and contains(text(), 'MOVE TO PAYMENT')]");
    private final SelenideElement returnToOfferHasToBeAcceptedButton = $x("//div[@class='task-status__body-item' and contains(text(), 'Return to Offer has to be accepted')]");
    private final SelenideElement startDeliveryStatusButton = $x("//div[@class='task-status__body-item' and contains(text(), 'START DELIVERY')]");
    private final SelenideElement moveToDoneStatusButton = $x("//div[@class='task-status__body-item' and contains(text(), 'MOVE TO DONE')]");
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
    private final SelenideElement logoImage = $x("//div[@class='header__left']");
    private final SelenideElement editOfferLink = $x("//a[contains(text(), 'Edit')]");
    private final SelenideElement legalBoardLink = $x("//a[contains(text(), 'Legal Board')]");
    private final SelenideElement addTaskButton = $x("//*[text() = 'ADD TASK']");
    private final SelenideElement offerTitle = $x("//h2[contains(@class, 'heading')]");
    private final SelenideElement returnToInProgressButton = $x("//button[contains(text(), 'Return to In Progress')]");


    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        return new LoginCabinetPage();
    }

    public ManagerDetailOfferPage clickPublishButton(){
        publishButton.click();
        sleep(3000);
        return this;
    }

    public String getMoveToNextStatusButton(){
        return moveToNextStatusButton.getText();
    }

    public ManagerDetailOfferPage clickStatusesDropDown(){
        statusesDropDown.click();
        return this;
    }

    public ManagerDetailOfferPage clickMoveToPaymentStatusButton(){
        moveToPaymentStatusButton.click();
        sleep(2000);
        return this;
    }

    public ManagerDetailOfferPage clickReturnToOfferHasToBeAcceptedButton(){
        returnToOfferHasToBeAcceptedButton.click();
        sleep(2000);
        return this;
    }

    public ManagerDetailOfferPage clickStartDeliveryStatusButton(){
        startDeliveryStatusButton.click();
        sleep(2000);
        return this;
    }

    public ManagerDetailOfferPage clickMoveToDoneStatusButton(){
        moveToDoneStatusButton.click();
        sleep(3000);
        return this;
    }

    public String getNextStepText(){
        sleep(3000);
        return nextStepText.getText();
    }

    public String getOfferStatusText(){
        sleep(2000);
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
        sleep(2000);
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

    public ManagerDetailOfferPage scrollToUpPage(){
        logoImage.scrollIntoView(false);
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

    public EditOfferOverlay clickEditOfferLink(){
        editOfferLink.click();
        sleep(3000);
        return new EditOfferOverlay();
    }

    public ManagerKanbanPage clickLegalBoardLink(){
        legalBoardLink.click();
        return new ManagerKanbanPage();
    }

    public AddTaskOverlay clickAddTaskButton(){
        addTaskButton.click();
        sleep(3000);
        return new AddTaskOverlay();
    }

    public AddTaskOverlay clickEditTaskButton(String taskTitle){
        $x("//td[text() = '" + taskTitle + "']/following-sibling::td/a[contains(@class, 'desc-edit')]").click();
        sleep(4000);
        return new AddTaskOverlay();
    }

    public ManagerDetailOfferPage clickDeleteTaskButton(String taskTitle){
        $x("//td[text() = '" + taskTitle + "']/following-sibling::td/a[contains(@class, 'milestones__delete')]").click();
        sleep(3000);
        return this;
    }

    public ManagerDetailOfferPage clickReturnToInProgressButton(){
        returnToInProgressButton.click();
        sleep(3000);
        return this;
    }

    public String getOfferTitle(){
        return offerTitle.getText();
    }

}
