package com.test.registration.second_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyClickNextButtonTest extends PrepareSecondRegistrationPageTestData {
    @Test
    void verifyClickNextButton(){
                new FirstRegistrationPage()
                        .choiceOneRandomCheckbox();
                sleep(1000);
                new SecondRegistrationPage().clickNextButton();
        Assertions.assertEquals("3/4", new ThirdRegistrationPage().getStepNumberTextLabel(), "'3/4' should be shown");
    }
}
