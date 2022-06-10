package com.test.registration.third_page_registration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.test.registration.Functions;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ThirdRegistrationPage {

    private SelenideElement stepNumber = $x("//div[contains(@class, 'header-container')]/b");
    private SelenideElement pageTitle = $x("//*[text() = 'This is how similar requests are usually solved']");
    private SelenideElement moveForwardToRegisterAndBookACall = $x("//*[text() = 'Move forward to register and book a call with lawyer to discuss the suggested legal solutions']");
    private SelenideElement weHaveMatchedYourBusinessNeedsWithTheLegalSolutions = $x("//*[text() = 'We have matched your business needs with the legal solutions.']");
    private SelenideElement backButton = $x("//*[text() = 'back']");
    private SelenideElement connectButton = $x("//*[text() = 'CONNECT']/..");
    private SelenideElement selectedOneOption = $x("//*[contains(@class,'ThirdStep_needItem')]");
    private SelenideElement selectedOneSection = $x("//*[contains(@class,'ThirdStep_categoryCol')]");

    private ElementsCollection selectedOptions = $$x("//*[contains(@class, 'ThirdStep_needItem')]");

    public String getStepNumber(){
        return stepNumber.getText();
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public String getMoveForwardToRegisterAndBookACall(){
        return moveForwardToRegisterAndBookACall.getText();
    }

    public String getWeHaveMatchedYourBusinessNeedsWithTheLegalSolutions(){
        return weHaveMatchedYourBusinessNeedsWithTheLegalSolutions.getText();
    }

    public String[] getSecondColumnTable(){
        selectedOneSection.shouldHave(visible);
        String[] chosenListSecondColumnTable = new Functions().getChosenOptions(selectedOptions);
        return chosenListSecondColumnTable;
    }

    public SecondRegistrationPage clickBackButton() {
        selectedOneSection.shouldHave(visible);
        backButton.click();
        return new SecondRegistrationPage();
    }

    public FourthRegistrationPage clickConnectButton() {
        selectedOneSection.shouldHave(visible);
        connectButton.click();
        return new FourthRegistrationPage();
    }

    public String getOneChosenOption(){
        String chosenOptionText = selectedOneOption.getText();
        return chosenOptionText;
    }

    public String getSectionForChosenOption(){
        String chosenSectionText = selectedOneSection.getText();
        return chosenSectionText;
    }
}
