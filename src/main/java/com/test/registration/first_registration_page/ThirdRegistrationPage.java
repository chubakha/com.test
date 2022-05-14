package com.test.registration.first_registration_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ThirdRegistrationPage {
    private SelenideElement connectButton = $x("//*[text() = 'CONNECT']");
    private SelenideElement backButton = $x("//*[text() = 'BACK']");
    private SelenideElement thisIsHowSimilarRequestsAreUsuallySolved = $x("//*[text() = 'This is how similar requests are usually solved']");
    private SelenideElement stepNumberTextLabel = $x("//div[@class='registration-quiz__header-container']/b");
    private SelenideElement weHaveMatchedYourBusinessNeedsWithTheLegalSolutions = $x("//*[text() = 'We have matched your business needs with the legal solutions.']");
    private SelenideElement moveForwardToRegisterAndBookACallWithLawyerToDiscussTheSuggestedLegalSolutions = $x("//*[text() = 'Move forward to register and book a call with lawyer to discuss the suggested legal solutions']");

    public FourthRegistrationPage clickConnectBtn() {
        connectButton.click();
        return new FourthRegistrationPage();
    }

    public SecondRegistrationPage clickBackButton() {
        backButton.click();
        return new SecondRegistrationPage();
    }

    public String getThisIsHowSimilarRequestsAreUsuallySolved(){
        return thisIsHowSimilarRequestsAreUsuallySolved.getText();
    }

    public String getStepNumberTextLabel(){
        return stepNumberTextLabel.getText();
    }

    public String getWeHaveMatchedYourBusinessNeedsWithTheLegalSolutions(){
        return weHaveMatchedYourBusinessNeedsWithTheLegalSolutions.getText();
    }

    public String getMoveForwardToRegisterAndBookACallWithLawyerToDiscussTheSuggestedLegalSolutions(){
        return moveForwardToRegisterAndBookACallWithLawyerToDiscussTheSuggestedLegalSolutions.getText();
    }
}
