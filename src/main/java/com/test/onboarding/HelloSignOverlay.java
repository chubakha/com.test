package com.test.onboarding;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class HelloSignOverlay {

    private final SelenideElement fullNameField = $x("//textarea[1]");
    private final SelenideElement companyField = $x("//*[contains(@class, '')][2]/div/div/div/textarea");
    private final SelenideElement companyNumberField = $x("//*[translate(@placeholder, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'company number']");
    private final SelenideElement addressField = $x("//*[@placeholder = 'Address']");
    private final SelenideElement positionField = $x("//textarea[contains(@placeholder, 'Title')]");
    private final SelenideElement signatureField = $x("//div[@tabindex = '0']");
    private final SelenideElement signatureTwoField = $x("//div[@data-field = 'Signature2']");
    private final SelenideElement nextStepButton = $x("//button[@data-qa-ref = 'button-next']");
    private final SelenideElement agreeButton = $x("//button[@data-qa-ref = 'button-agree']");

    public HelloSignOverlay setFullNameField(String fullName){
        sleep(20000);
        fullNameField.val(fullName);
        return this;
    }

    public HelloSignOverlay clickFullNameField(){
        fullNameField.click();
        return this;
    }

    public HelloSignOverlay setCompanyField(String company){
        companyField.val(company);
        return this;
    }

    public HelloSignOverlay setCompanyNumberField(String companyNumber){
        companyNumberField.val(companyNumber);
        return this;
    }

    public HelloSignOverlay setAddressField(String address){
        addressField.val(address);
        return this;
    }

    public HelloSignOverlay setPositionField(String position){
        positionField.val(position);
        return this;
    }

    public AddSignatureOverlay clickSignatureField(){
        signatureField.click();
        return new AddSignatureOverlay();
    }

    public HelloSignOverlay clickSignatureTwoField(){
        signatureTwoField.click();
        return this;
    }

    public HelloSignOverlay clickNextStepButton(){
        nextStepButton.click();
        return this;
    }

    public HelloSignOverlay clickAgreeButton(){
        sleep(1000);
        agreeButton.click();
        return this;
    }

}
