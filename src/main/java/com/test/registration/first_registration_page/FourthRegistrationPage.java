package com.test.registration.first_registration_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FourthRegistrationPage {
    private SelenideElement firstNameField = $x("//input[@placeholder='First name']");
    private SelenideElement lastNameField = $x("//input[@placeholder='Last name']");
    private SelenideElement emailField = $x("//input[@placeholder='Email']");
    private SelenideElement companyNameField = $x("//input[@placeholder='Company']");
    private SelenideElement passwordField = $x("//input[@placeholder='Password']");
    private SelenideElement repeatPasswordField = $x("//input[@placeholder='Repeat password']");
    private SelenideElement createAccountButton = $x("//*[text() = 'CREATE ACCOUNT']");
    private SelenideElement policyCheckBox = $x("//div[contains(@class,'checkbox_container')]");
    private SelenideElement createAnAccount = $x("//*[text() = 'Create an account']");
    private SelenideElement stepNumberTextLabel = $x("//div[@class='registration-quiz__header-container']/b");

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public FourthRegistrationPage clickPrivacyPolicy() {
        policyCheckBox.click();
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
        return createAnAccount.getText();
    }

    public String getStepNumberTextLabel(){
        return stepNumberTextLabel.getText();
    }
}
