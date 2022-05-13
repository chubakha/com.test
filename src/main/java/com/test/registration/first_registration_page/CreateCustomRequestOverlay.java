package com.test.registration.first_registration_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateCustomRequestOverlay {
    private SelenideElement needHelpWithSomethingElseTextArea = $x("//*[contains(@class, 'CustomModal_textarea')]");

    public boolean isNeedHelpWithSomethingElse(){
        return $x("//div[contains(@class, 'slide-enter-done')]").isDisplayed();
    }

    public CreateCustomRequestOverlay setNeedHelpWithSomethingElseText(String text){
        needHelpWithSomethingElseTextArea.val(text);
        return this;
    }

    public String getNeedHelpWithSomethingElseText(){
        return needHelpWithSomethingElseTextArea.getText();
    }

    public String getNeedHelpWithSomethingElseTitle(){
        return $x("//h2[contains(@class, 'CustomModal_heading')]").getText();
    }

    public FirstRegistrationPage clickNeedHelpWithSomethingElseSendButton(){
        $x("//*[text() = 'SEND']").click();
        return new FirstRegistrationPage();
    }

    public FirstRegistrationPage clickHelpWithSomethingElseClosePopup(){
        $x("//img[contains(@class, 'CustomModal_close')]").click();
        return new FirstRegistrationPage();
    }
}
