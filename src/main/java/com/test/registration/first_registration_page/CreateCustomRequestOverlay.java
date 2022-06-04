package com.test.registration.first_registration_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateCustomRequestOverlay {
    private SelenideElement needHelpWithSomethingElseTextArea = $x("//*[contains(@class, 'CustomModal_textarea')]");
    private SelenideElement needHelpWithSomethingElsePopupTitle = $x("//*[contains(@class, 'slide-enter-done')]");
    private SelenideElement needHelpWithSomethingElseTitle = $x("//h2[contains(@class, 'CustomModal_heading')]");
    private SelenideElement needHelpWithSomethingElseSendButton = $x("//*[text() = 'SEND']");
    private SelenideElement needHelpWithSomethingElseClosePopup = $x("//img[contains(@class, 'CustomModal_close')]");

    public boolean isNeedHelpWithSomethingElseShown(){
        return needHelpWithSomethingElsePopupTitle.shouldBe(Condition.visible).isDisplayed();
    }

    public CreateCustomRequestOverlay setNeedHelpWithSomethingElseText(String text){
        needHelpWithSomethingElseTextArea.val(text);
        return this;
    }

    public String getNeedHelpWithSomethingElseText(){
        return needHelpWithSomethingElseTextArea.getText();
    }

    public String getNeedHelpWithSomethingElseTitle(){
        return needHelpWithSomethingElseTitle.getText();
    }

    public FirstRegistrationPage clickNeedHelpWithSomethingElseSendButton(){
        needHelpWithSomethingElseSendButton.click();
        return new FirstRegistrationPage();
    }

    public FirstRegistrationPage clickNeedHelpWithSomethingElseClosePopup(){
        needHelpWithSomethingElseClosePopup.click();
        return new FirstRegistrationPage();
    }
}
