package com.test.registration.fourth_registration_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FourthRegistrationPage {
    private SelenideElement firstNameField = $x("//input[@placeholder='First name']");
    private SelenideElement lastNameField = $x("//input[@placeholder='Last name']");
    private SelenideElement emailField = $x("//input[@placeholder='Email']");
    private SelenideElement companyNameField = $x("//input[@placeholder='Company']");
    private SelenideElement passwordField = $x("//input[@placeholder='Password']");
    private SelenideElement repeatPasswordField = $x("//input[@placeholder='Repeat password']");
    private SelenideElement iveReadAndAcceptedTermsConditionsAndPrivacyPolicy = $x("//div[contains(@class,'checkbox_container')]");
    private SelenideElement createAccountButton = $x("//*[text() = 'CREATE ACCOUNT']/..");

    public FourthRegistrationPage clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy() {
        iveReadAndAcceptedTermsConditionsAndPrivacyPolicy.click();
        return this;
    }

    public FourthRegistrationPage setFirstNameField(String first_name){
        firstNameField.val(first_name);
        return this;
    }

    public String getFirstNameField(){
        return firstNameField.getText();
    }

    public FourthRegistrationPage setLastNameField(String last_name){
        lastNameField.val(last_name);
        return this;
    }

    public String getLastNameField(){
        return lastNameField.getText();
    }

    public FourthRegistrationPage setCompanyNameField(String company_name){
        companyNameField.val(company_name);
        return this;
    }

    public String getCompanyNameField(){
        return companyNameField.getText();
    }

    public FourthRegistrationPage setEmailField(String email){
        emailField.val(email);
        return this;
    }

    public String getEmailField(){
        return emailField.getText();
    }

    public FourthRegistrationPage setPasswordField(String password1){
        passwordField.val(password1);
        return this;
    }

    public String getPasswordField(){
        return passwordField.getText();
    }

    public FourthRegistrationPage setRepeatPasswordField(String password2){
        repeatPasswordField.val(password2);
        return this;
    }

    public String getRepeatPasswordField(){
        return repeatPasswordField.getText();
    }

    public String getCreateAnAccount(){
        return $x("//*[text() = 'Create an account']").getText();
    }

    public String getStepNumberTextLabel(){
        return $x("//div[@class='registration-quiz__header-container']/b").getText();
    }

    public String getDisabledCreateAccountButton(){
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
