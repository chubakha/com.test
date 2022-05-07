package com.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends BasePage {

    //registration checkboxes and buttons
    private SelenideElement optionCheckBox = $x("(//*[contains(@class,'checkbox_container')])[1]");

    private SelenideElement nextBtn = $x("//*[contains(@class,'FirstStep_nextButton')]");
    private SelenideElement backBtn = $x("//*[contains(@class,'FirstStep_prevButton')]");
    private SelenideElement policyCheckBox = $x("//*[contains(@class,'checkbox_container')]");
    private SelenideElement needTextLabel = $x("(//*[contains(@class,'checkbox_container')])[1]/following::span[1]");
    private SelenideElement customNeedBtn = $x("(//*[contains(@class,'FirstStep_customRequestBlock')])[1]");
    private SelenideElement connectBtn = $x("//span[contains(text(),'CONNECT')]");
    private SelenideElement createAccountBtn = $x("//span[contains(text(),'CREATE ACCOUNT')]");

    //registration title and step number
    private SelenideElement titleTextLabel = $x("//*[@class='registration-quiz__header-container']/h3");
    private SelenideElement stepNumberTextLabel = $x("//*[@class='registration-quiz__header-container']/b");

    //registration tool tips
    private SelenideElement toolTipIcon = $x("(//*[contains(@class,'FirstStep_firstStepBlockTooltip')])[1]");
    private SelenideElement toolTipText = $x("(//*[contains(@class,'FirstStep_firstStepBlockTooltipDropDown')])[1]");

    //registration form
    private SelenideElement firstNameField = $x("//input[@placeholder='First name']");
    private SelenideElement lastNameField = $x("//input[@placeholder='Last name']");
    private SelenideElement emailField = $x("//input[@placeholder='Email']");
    private SelenideElement companyNameField = $x("//input[@placeholder='Company']");
    private SelenideElement password1Field = $x("//input[@placeholder='Password']");
    private SelenideElement password2Field = $x("//input[@placeholder='Repeat password']");


    public SecondRegistrationPage registrationClient(){
        clickRegistrationOptionCheckBox();
        clickRegistrationNextBtn();
        sleep(2000);
        clickRegistrationNextBtn();
        sleep(2000);
        clickRegistrationConnectBtn();
        setRegistrationFirstName(REGISTRATION_FIRST_NAME);
        setRegistrationLastName(REGISTRATION_LAST_NAME);
        setRegistrationCompanyName(REGISTRATION_COMPANY_NAME);
        setRegistrationEmail(REGISTRATION_EMAIL);
        setRegistrationPassword1(REGISTRATION_PASSWORD1);
        setRegistrationPassword2(REGISTRATION_PASSWORD2);
        clickRegistrationPrivacyPolicy();
        clickCreateAccountBtn();
        return new SecondRegistrationPage();
    }


    public void clickRegistrationOptionCheckBox() {
        optionCheckBox.click();
    }

    public void clickRegistrationNextBtn() {
        nextBtn.click();
    }

    public void clickRegistrationCustomNeedBtn() {
        customNeedBtn.click();
    }

    public void clickRegistrationBackBtn() {
        backBtn.click();
    }

    public void clickRegistrationNextStepBtn() {
        nextBtn.click();
    }

    public void clickRegistrationConnectBtn() {
        connectBtn.click();
    }

    public void clickRegistrationPrivacyPolicy() {
        policyCheckBox.click();
    }

    public void clickCreateAccountBtn() {
        createAccountBtn.click();
    }

    public void hoverRegistrationInfoIcon(){
        toolTipIcon.hover();
    }

    public String getRegistrationTitleTextLabel(){
        return titleTextLabel.getText();
    }

    public String getRegistrationStepNumberTextLabel(){
        return stepNumberTextLabel.getText();
    }

    public String getRegistrationNeedTextLabel(){
        return needTextLabel.getText();
    }

    public String getRegistrationToolTipText(){
        return toolTipText.getText();
    }

    public RegistrationPage setRegistrationFirstName(String first_name){
        firstNameField.val(first_name);
        return this;
    }

    public String getRegistrationFirstName(){
        return firstNameField.getText();
    }

    public RegistrationPage setRegistrationLastName(String last_name){
        lastNameField.val(last_name);
        return this;
    }

    public String getRegistrationLastName(){
        return lastNameField.getText();
    }

    public RegistrationPage setRegistrationCompanyName(String company_name){
        companyNameField.val(company_name);
        return this;
    }

    public String getRegistrationCompanyName(){
        return companyNameField.getText();
    }

    public RegistrationPage setRegistrationEmail(String email){
        emailField.val(email);
        return this;
    }

    public String getRegistrationEmail(){
        return emailField.getText();
    }

    public RegistrationPage setRegistrationPassword1(String password1){
        password1Field.val(password1);
        return this;
    }

    public String getRegistrationPassword1(){
        return password1Field.getText();
    }

    public RegistrationPage setRegistrationPassword2(String password2){
        password2Field.val(password2);
        return this;
    }

    public String getRegistrationPassword2(){
        return password2Field.getText();
    }


}
