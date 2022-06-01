package com.test.registration.second_registration_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.test.registration.Functions;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;

import java.util.*;


import static com.codeborne.selenide.Selenide.*;

public class SecondRegistrationPage {

    private ElementsCollection selectedOptions = $$x("//div[contains(@class, 'checkbox_containerActive')]/following-sibling::span");

    public ThirdRegistrationPage clickNextButton() {
        System.out.println("456");
        $x("//*[text() = 'NEXT']/..").shouldHave(Condition.visible).click();
        return new ThirdRegistrationPage();
    }

    public FirstRegistrationPage clickBackButton() {
        $x("//*[text() = 'back']").click();
        return new FirstRegistrationPage();
    }

    public String getPleaseCheckTheListOfTasksWhichShouldBeLegallySortedOut() {
        return $x("//*[text() = 'Please check the list of tasks which should be legally sorted out']").getText();
    }

    public String getRegistrationPageNumber() {
        return $x("//div[contains(@class, 'header-container')]/b").getText();
    }

    public String[] getSelectedOptions() {
        String[] chosenListSecondPage = new Functions().getChosenOptions(selectedOptions);
        return chosenListSecondPage;
    }

    public SecondRegistrationPage deleteLead(String leadName) {
        $x("//*[contains(text(), '" + leadName + "')]").click();
        return this;
    }

    public String getRandomLead(){
        String[] chosenListSecondPage = getSelectedOptions();
        return getSelectedOptions()[new Random().nextInt(chosenListSecondPage.length / 2)];
    }

    public FirstRegistrationPage deleteOneChosenOptionFromOne() {
        $x("(//span[contains(@class,'checkbox_label')])[1]").click();
        return new FirstRegistrationPage();
    }

    public String getOneChosenOption(){
        String chosenOption = $x("//*[contains(@class,'checkbox_label')]").getText();
        return chosenOption;
    }

    public String getOneChosenSection(){
        String chosenOption = $x("//*[contains(@class,'FirstStep_firstStepBlockHeading')]").getText();
        return chosenOption;
    }


}