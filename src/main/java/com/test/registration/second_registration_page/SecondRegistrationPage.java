package com.test.registration.second_registration_page;

import com.codeborne.selenide.SelenideElement;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.first_registration_page.ThirdRegistrationPage;

import static com.codeborne.selenide.Selenide.$x;

public class SecondRegistrationPage {

   /* private SelenideElement nextButton = $x("//*[text() = 'NEXT']");
    private SelenideElement backButton = $x("//*[text() = 'BACK']");
    private SelenideElement pleaseCheckTheListOfTasksWhichShouldBeLegallySortedOut = $x("//*[text() = 'Please check the list of tasks which should be legally sorted out']");

    public FirstRegistrationPage deleteCheckedValue(String value){
        String xpath = String.format("//*[text() = '%s']", value);
        $x(xpath).click();
        return new FirstRegistrationPage();
    }

    public ThirdRegistrationPage clickNextButton() {
        nextButton.click();
        return new ThirdRegistrationPage();
    }

    public FirstRegistrationPage clickBackButton() {
        backButton.click();
        return new FirstRegistrationPage();
    }

    public String getPleaseCheckTheListOfTasksWhichShouldBeLegallySortedOut(){
        return pleaseCheckTheListOfTasksWhichShouldBeLegallySortedOut.getText();
    }*/

    public String getStepNumberTextLabel(){
        return $x("//div[@class='registration-quiz__header-container']/b").getText();
    }
}
