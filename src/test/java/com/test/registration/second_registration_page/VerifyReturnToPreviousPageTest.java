package com.test.registration.second_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyReturnToPreviousPageTest extends PrepareSecondRegistrationPageTestData{
    @Test
    void verifyReturnToPreviousPage(){
        FirstRegistrationPage firstRegistrationPage =
                new FirstRegistrationPage()
                        .choiceOneRandomCheckbox()
                        .clickBackButton();
        Assertions.assertEquals("1/4", firstRegistrationPage.getStepNumberTextLabel(), "1/4 should be shown");
    }
}
