package com.test.registration.fourth_registration_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FourthRegistrationPage {
    private SelenideElement firstNameField = $x("//input[@placeholder='First name']");
    private SelenideElement fieldIsRequiredForFirstNameField = $x("//input[@placeholder='First name']/following-sibling::p");
    private SelenideElement lastNameField = $x("//input[@placeholder='Last name']");
    private SelenideElement fieldIsRequiredForLastNameField = $x("//input[@placeholder='Last name']/following-sibling::p");
    private SelenideElement emailField = $x("//input[@placeholder='Email']");
    private SelenideElement fieldIsRequiredForEmailField = $x("//input[@placeholder='Email']/following-sibling::p");
    private SelenideElement companyNameField = $x("//input[@placeholder='Company']");
    private SelenideElement fieldIsRequiredForCompanyNameField = $x("//input[@placeholder='Company']/following-sibling::p");
    private SelenideElement passwordField = $x("//input[@placeholder='Password']");
    private SelenideElement fieldIsRequiredForPasswordField = $x("//input[@placeholder='Password']/following-sibling::p");
    private SelenideElement repeatPasswordField = $x("//input[@placeholder='Repeat password']");
    private SelenideElement fieldIsRequiredForRepeatPasswordField = $x("//input[@placeholder='Repeat password']/following-sibling::p");
    private SelenideElement iveReadAndAcceptedTermsConditionsAndPrivacyPolicy = $x("//div[contains(@class,'checkbox_container')]");
    private SelenideElement createAccountButton = $x("//*[text() = 'CREATE ACCOUNT']/..");
    private SelenideElement termsAndConditionsLink = $x("//*[text() = 'Terms & Conditions']");
    private SelenideElement privacyPolicyLink = $x("//*[text() = 'Privacy Policy']");
    private SelenideElement pageTitle = $x("//*[text() = 'Create an account']");
    private SelenideElement stepNumber = $x("//div[@class='registration-quiz__header-container']/b");

    public FourthRegistrationPage setFirstNameField(String first_name){
        firstNameField.val(first_name);
        return this;
    }

    public String getFirstNameField(){
        return firstNameField.shouldBe(Condition.visible).getText();
    }

    public boolean isFieldIsRequiredForFirstNameFieldShown(){
        return fieldIsRequiredForFirstNameField.isDisplayed();
    }

    public String getFieldIsRequiredForFirstNameField(){
        return fieldIsRequiredForFirstNameField.shouldBe(Condition.visible).getText();
    }

    public FourthRegistrationPage setLastNameField(String last_name){
        lastNameField.shouldBe(Condition.visible).val(last_name);
        return this;
    }

    public String getLastNameField(){
        return lastNameField.shouldBe(Condition.visible).getText();
    }

    public String getFieldIsRequiredForLastNameField(){
        return fieldIsRequiredForLastNameField.shouldBe(Condition.visible).getText();
    }

    public boolean isFieldIsRequiredForLastNameFieldShown(){
        return fieldIsRequiredForLastNameField.isDisplayed();
    }

    public FourthRegistrationPage setCompanyNameField(String company_name){
        companyNameField.shouldBe(Condition.visible).val(company_name);
        return this;
    }

    public String getCompanyNameField(){
        return companyNameField.shouldBe(Condition.visible).getText();
    }

    public String getFieldIsRequiredForCompanyNameField(){
        return fieldIsRequiredForCompanyNameField.shouldBe(Condition.visible).getText();
    }

    public boolean isFieldIsRequiredForCompanyNameFieldShown(){
        return fieldIsRequiredForCompanyNameField.isDisplayed();
    }

    public FourthRegistrationPage setEmailField(String email){
        emailField.shouldBe(Condition.visible).val(email);
        return this;
    }

    public String getEmailField(){
        return emailField.shouldBe(Condition.visible).getText();
    }

    public String getFieldIsRequiredForEmailField(){
        return fieldIsRequiredForEmailField.shouldBe(Condition.visible).getText();
    }

    public boolean isFieldIsRequiredForEmailFieldShown(){
        return fieldIsRequiredForEmailField.isDisplayed();
    }

    public FourthRegistrationPage setPasswordField(String password1){
        passwordField.shouldBe(Condition.visible).val(password1);
        return this;
    }

    public String getPasswordField(){
        return passwordField.shouldBe(Condition.visible).getText();
    }

    public String getFieldIsRequiredForPasswordField(){
        return fieldIsRequiredForPasswordField.shouldBe(Condition.visible).getText();
    }

    public boolean isFieldIsRequiredForPasswordFieldShown(){
        return fieldIsRequiredForPasswordField.isDisplayed();
    }

    public FourthRegistrationPage setRepeatPasswordField(String password2){
        repeatPasswordField.shouldBe(Condition.visible).val(password2);
        return this;
    }

    public String getRepeatPasswordField(){
        return repeatPasswordField.shouldBe(Condition.visible).getText();
    }

    public String getFieldIsRequiredForRepeatPasswordField(){
        return fieldIsRequiredForRepeatPasswordField.shouldBe(Condition.visible).getText();
    }

    public boolean isFieldIsRequiredForRepeatPasswordFieldShown(){
        return fieldIsRequiredForRepeatPasswordField.isDisplayed();
    }

    public FourthRegistrationPage clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy() {
        iveReadAndAcceptedTermsConditionsAndPrivacyPolicy.shouldBe(Condition.visible).click();
        return this;
    }

    public AttachmentDocumentsOverlay clickTermsAndConditionsLink(){
        termsAndConditionsLink.shouldBe(Condition.visible).click();
        return new AttachmentDocumentsOverlay();
    }

    public AttachmentDocumentsOverlay clickPrivacyPolicyLink(){
        privacyPolicyLink.shouldBe(Condition.visible).click();
        return new AttachmentDocumentsOverlay();
    }

    public String getPageTitle(){
        return pageTitle.shouldBe(Condition.visible).getText();
    }

    public String getStepNumber(){
        return stepNumber.shouldBe(Condition.visible).getText();
    }

    public String getDisabledCreateAccountButton(){
        stepNumber.shouldHave(Condition.text("4/4"));
        return createAccountButton.getAttribute("disabled");
    }

    public void clickCreateAccountButton() {
        createAccountButton.shouldBe(Condition.visible).click();
    }

    public FourthRegistrationPage clickInactiveCreateAccountButton() {
        clickCreateAccountButton();
        return new FourthRegistrationPage();
    }

    public FourthRegistrationPage clickActiveCreateAccountButton() {
        clickCreateAccountButton();
        return new FourthRegistrationPage();
    }

}
