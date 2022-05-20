package com.test.registration.third_page_registration;

import com.codeborne.selenide.ElementsCollection;
import com.test.registration.Functions;

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
}
