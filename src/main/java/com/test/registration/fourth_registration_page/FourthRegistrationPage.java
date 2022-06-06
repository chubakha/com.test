package com.test.registration.fourth_registration_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
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
        return firstNameField.getText();
    }

    public boolean isFieldIsRequiredForFirstNameFieldShown(){
        return fieldIsRequiredForFirstNameField.isDisplayed();
    }

    public String getFieldIsRequiredForFirstNameField(){
        return fieldIsRequiredForFirstNameField.getText();
    }

    public FourthRegistrationPage setLastNameField(String last_name){
        lastNameField.val(last_name);
        return this;
    }

    public String getLastNameField(){
        return lastNameField.getText();
    }

    public String getFieldIsRequiredForLastNameField(){
        return fieldIsRequiredForLastNameField.getText();
    }

    public boolean isFieldIsRequiredForLastNameFieldShown(){
        return fieldIsRequiredForLastNameField.isDisplayed();
    }

    public FourthRegistrationPage setCompanyNameField(String company_name){
        companyNameField.val(company_name);
        return this;
    }

    public String getCompanyNameField(){
        return companyNameField.getText();
    }

    public String getFieldIsRequiredForCompanyNameField(){
        return fieldIsRequiredForCompanyNameField.getText();
    }

    public boolean isFieldIsRequiredForCompanyNameFieldShown(){
        return fieldIsRequiredForCompanyNameField.isDisplayed();
    }

    public FourthRegistrationPage setEmailField(String email){
        emailField.val(email);
        return this;
    }

    public String getEmailField(){
        return emailField.getText();
    }

    public String getFieldIsRequiredForEmailField(){
        return fieldIsRequiredForEmailField.getText();
    }

    public boolean isFieldIsRequiredForEmailFieldShown(){
        return fieldIsRequiredForEmailField.isDisplayed();
    }

    public FourthRegistrationPage setPasswordField(String password1){
        passwordField.val(password1);
        return this;
    }

    public String getPasswordField(){
        return passwordField.getText();
    }

    public String getFieldIsRequiredForPasswordField(){
        return fieldIsRequiredForPasswordField.getText();
    }

    public FourthRegistrationPage setRepeatPasswordField(String password2){
        repeatPasswordField.val(password2);
        return this;
    }

    public String getRepeatPasswordField(){
        return repeatPasswordField.getText();
    }

    public String getFieldIsRequiredForRepeatPasswordField(){
        return fieldIsRequiredForRepeatPasswordField.getText();
    }

    public FourthRegistrationPage clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy() {
        iveReadAndAcceptedTermsConditionsAndPrivacyPolicy.click();
        return this;
    }

    public TermsAndConditionsOverlay clickTermsAndConditionsLink(){
        termsAndConditionsLink.click();
        return new TermsAndConditionsOverlay();
    }

    public FourthRegistrationPage clickPrivacyPolicyLink(){
        privacyPolicyLink.click();
        return this;
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public String getStepNumber(){
        return stepNumber.getText();
    }

    public String getDisabledCreateAccountButton(){
        stepNumber.shouldHave(Condition.text("4/4"));
        return createAccountButton.getAttribute("disabled");
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
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
