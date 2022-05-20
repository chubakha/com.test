package com.test.registration.second_registration_page;

import com.codeborne.selenide.ElementsCollection;
import com.test.registration.Functions;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;

import java.util.Arrays;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class SecondRegistrationPage {

    private ElementsCollection selectedOptions = $$x("//div[contains(@class, 'checkbox_containerActive')]/following-sibling::span");

    public ThirdRegistrationPage clickNextButton() {
        $x("//*[text() = 'NEXT']").click();
        return new ThirdRegistrationPage();
    }

    public FirstRegistrationPage clickBackButton() {
        $x("//*[text() = 'back']").click();
        return new FirstRegistrationPage();
    }

    public String getPleaseCheckTheListOfTasksWhichShouldBeLegallySortedOut(){
        return $x("//*[text() = 'Please check the list of tasks which should be legally sorted out']").getText();
    }

    public String getStepNumberTextLabel(){
        return $x("//div[@class='registration-quiz__header-container']/b").getText();
    }

    public String[] getAllChosenOptions(){
        String[] chosenListSecondPageCopy = new Functions().getChosenOptions(selectedOptions);
        String[] chosenListSecondPage = Arrays.copyOfRange(chosenListSecondPageCopy, 0, chosenListSecondPageCopy.length/2);
        return chosenListSecondPage;
    }

    public String deleteOneChosenOptionFromFew(){
        String[] chosenListSecondPage = getAllChosenOptions();
        String deletingElement = chosenListSecondPage[new Random().nextInt(chosenListSecondPage.length/2)];
        $x("//*[contains(text(), '" + deletingElement + "')]").click();
        return deletingElement;
    }

    public FirstRegistrationPage deleteOneChosenOptionFromOne(){
        $x("(//span[contains(@class,'checkbox_label')])[1]").click();
        return new FirstRegistrationPage();
    }
}
