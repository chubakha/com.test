package com.test.registration.first_registration_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateCustomRequestOverlay {
    private SelenideElement needHelpWithSomethingElseTextArea = $x("//*[contains(@class, 'CustomModal_textarea')]");

    public boolean isNeedHelpWithSomethingElse(){
        return $x("//*[contains(@class, 'CustomModal_heading') and contains(text(), 'Create Custom Request')]").isDisplayed();
    }

    public CreateCustomRequestOverlay setNeedHelpWithSomethingElseText(String text){
        needHelpWithSomethingElseTextArea.val(text);
        return this;
    }

    public String getNeedHelpWithSomethingElseText(){
        return needHelpWithSomethingElseTextArea.getText();
    }
}
