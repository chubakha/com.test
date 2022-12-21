package com.test.onboarding;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AddSignatureOverlay {

    private final SelenideElement signByTypeButton = $x("//li[@data-qa-ref = 'signing-modal--T']");
    private final SelenideElement signNameField = $x("//input[@data-qa-ref = 'signing-modal--type-in-field']");
    private final SelenideElement insertEverywhereSignButton = $x("//button[@data-qa-ref = 'singing-modal--insert-btn']/following-sibling::button");

    public AddSignatureOverlay clickSignByTypeButton(){
        signByTypeButton.click();
        return this;
    }

    public AddSignatureOverlay setSignField(String sign){
        signNameField.val(sign);
        return this;
    }

    public HelloSignOverlay clickInsertEverywhereSignButton(){
        insertEverywhereSignButton.click();
        return new HelloSignOverlay();
    }

}
