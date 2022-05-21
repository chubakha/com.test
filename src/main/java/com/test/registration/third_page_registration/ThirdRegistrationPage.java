package com.test.registration.third_page_registration;

import com.codeborne.selenide.ElementsCollection;
import com.test.registration.Functions;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ThirdRegistrationPage {

    private ElementsCollection selectedOptions = $$x("//*[contains(@class, 'ThirdStep_needItem')]");

    public String getStepNumberTextLabel(){
        return $x("//div[@class='registration-quiz__header-container']/b").getText();
    }

    public String getThisIsHowSimilarRequestsAreUsuallySolved(){
        return $x("//*[text() = 'This is how similar requests are usually solved']").getText();
    }

    public String getMoveForwardToRegisterAndBookACall(){
        return $x("//*[text() = 'Move forward to register and book a call with lawyer to discuss the suggested legal solutions']").getText();
    }

    public String getWeHaveMatchedYourBusinessNeedsWithTheLegalSolutions(){
        return $x("//*[text() = 'We have matched your business needs with the legal solutions.']").getText();
    }

    public String[] getSecondColumnTable(){
        String[] chosenListSecondColumnTable = new Functions().getChosenOptions(selectedOptions);
        return chosenListSecondColumnTable;
    }

    public SecondRegistrationPage clickBackButton() {
        $x("//*[text() = 'back']").click();
        return new SecondRegistrationPage();
    }

    public FourthRegistrationPage clickConnectButton() {
        $x("//*[text() = 'CONNECT']").click();
        return new FourthRegistrationPage();
    }

    public String getOneChosenOption(){
        String chosenOption = $x("//*[contains(@class,'ThirdStep_needItem')]").getText();
        return chosenOption;
    }

    public String getOneChosenSection(){
        String chosenOption = $x("//*[contains(@class,'ThirdStep_categoryCol')]").getText();
        return chosenOption;
    }
}
