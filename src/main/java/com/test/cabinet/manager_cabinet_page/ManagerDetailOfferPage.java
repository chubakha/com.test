package com.test.cabinet.manager_cabinet_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ManagerDetailOfferPage {
    private final SelenideElement publishButton = $x("//button[contains(text(), 'Publish')]");
    private final SelenideElement moveToNextStatusButton = $x("//button[contains(@class(), 'offerHeader__button')]");
    private final SelenideElement statusesDropDown = $x("//div[@class = 'task-status']");
    private final SelenideElement moveToPaymentStatus = $x("//div[@class='task-status__body-item' and contains(text(), 'MOVE TO PAYMENT')]");
    private final SelenideElement startDeliveryStatus = $x("//div[@class='task-status__body-item' and contains(text(), 'START DELIVERY')]");
    private final SelenideElement moveToDoneStatus = $x("//div[@class='task-status__body-item' and contains(text(), 'MOVE TO DONE')]");
    private final SelenideElement nextStepText = $x("//span[@class='offerHeading__steps-step']");

    public ManagerDetailOfferPage clickPublishButton(){
        publishButton.click();
        return this;
    }

    public String getMoveToNextStatusButton(){
        return moveToNextStatusButton.getText();
    }

    public ManagerDetailOfferPage clickStatusesDropDown(){
        statusesDropDown.click();
        return new ManagerDetailOfferPage();
    }

    public ManagerDetailOfferPage clickMoveToPaymentStatus(){
        moveToPaymentStatus.click();
        return new ManagerDetailOfferPage();
    }

    public ManagerDetailOfferPage clickStartDeliveryStatus(){
        startDeliveryStatus.click();
        return new ManagerDetailOfferPage();
    }

    public ManagerDetailOfferPage clickMoveToDoneStatus(){
        moveToDoneStatus.click();
        return new ManagerDetailOfferPage();
    }

    public String getNextStepText(){
        return nextStepText.getText();
    }

}
