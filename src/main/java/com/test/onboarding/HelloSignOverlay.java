package com.test.onboarding;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HelloSignOverlay {

    private final SelenideElement fullNameField = $x("//div[contains(@data-field, 'Full') and contains(@data-field, 'name1')]/div/div/div/textarea");
    private final SelenideElement companyField = $x("//div[@data-field = 'Company']/div/div/div/textarea");
    private final SelenideElement companyNumberField = $x("//div[@data-field = 'CompanyNumber']/div/div/div/textarea");
    private final SelenideElement addressField = $x("//div[@data-field = 'Address']/div/div/div/textarea");
    private final SelenideElement positionField = $x("//div[@data-field = 'Title1']/div/div/div/textarea");
    private final SelenideElement signatureField = $x("//div[@data-field = 'Signature1']");
    private final SelenideElement signatureTwoField = $x("//div[@data-field = 'Signature2']");
    private final SelenideElement nextStepButton = $x("//button[@data-qa-ref = 'button-next']");
    private final SelenideElement agreeButton = $x("//button[@data-qa-ref = 'button-agree']");

    public HelloSignOverlay setFullNameField(String fullName){
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
        agreeButton.click();
        return this;
    }

}
