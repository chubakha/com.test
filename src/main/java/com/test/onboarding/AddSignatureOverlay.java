package com.test.onboarding;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AddSignatureOverlay {

    private final SelenideElement signByTypeButton = $x("//li[@data-qa-ref = 'signing-modal--T']");
    private final SelenideElement signNameField = $x("//input[@data-qa-ref = 'signing-modal--type-in-field']");
    private final SelenideElement insertSignButton = $x("//button[@data-qa-ref = 'singing-modal--insert-btn']");

    public AddSignatureOverlay clickSignByTypeButton(){
        signByTypeButton.click();
        return this;
    }

    public AddSignatureOverlay setSignField(String sign){
        signNameField.val(sign);
        return this;
    }

    public HelloSignOverlay clickInsertSignButton(){
        insertSignButton.click();
        return new HelloSignOverlay();
    }

}
