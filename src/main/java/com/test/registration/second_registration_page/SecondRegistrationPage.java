package com.test.registration.second_registration_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.test.registration.Functions;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;

import java.util.*;


import static com.codeborne.selenide.Selenide.*;

public class SecondRegistrationPage {

    private ElementsCollection selectedOptions = $$x("//div[contains(@class, 'FirstStep_firstStepBlockBodyItem')]/div[contains(@class, 'checkbox_containerActive')]/following-sibling::span");
    private SelenideElement nextButton = $x("//*[text() = 'NEXT']/..");
    private SelenideElement backButton = $x("//*[text() = 'back']");
    private SelenideElement pageTitle = $x("//*[text() = 'Please check the list of tasks which should be legally sorted out']");
    private SelenideElement stepNumber = $x("//div[contains(@class, 'header-container')]/b");
    private SelenideElement selectedOneOption = $x("//span[contains(@class,'checkbox_label')]");
    private SelenideElement selectedOneSection = $x("//*[contains(@class,'FirstStep_firstStepBlockHeading')]");


    public ThirdRegistrationPage clickNextButton() {
        nextButton.shouldBe(Condition.attribute("id", "")).click();
        return new ThirdRegistrationPage();
    }

    public FirstRegistrationPage clickBackButton() {
        backButton.click();
        return new FirstRegistrationPage();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getStepNumber() {
        return stepNumber.shouldHave(Condition.text("2/4")).getText();
    }

    public String[] getSelectedOptions() {
        String[] chosenOptionListOnSecondPage = new Functions().getChosenOptions(selectedOptions);
        return chosenOptionListOnSecondPage;
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
        nextButton.shouldBe(Condition.attribute("id", ""));
        selectedOneOption.click();
        return new FirstRegistrationPage();
    }

    public String getOneChosenOption(){
        return selectedOneOption.getText();
    }

    public String getOneChosenSection(){
        return selectedOneSection.getText();
    }


}