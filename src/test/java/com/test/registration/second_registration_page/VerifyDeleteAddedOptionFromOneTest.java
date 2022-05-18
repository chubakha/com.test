package com.test.registration.second_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyDeleteAddedOptionFromOneTest extends PrepareSecondRegistrationPageTestData{
    @Test
    void verifyDeleteAddedOptionFromOne(){
        FirstRegistrationPage firstRegistrationPage =
                new FirstRegistrationPage()
                        .choiceFirstCheckbox()
                        .deleteOneRandomChosenOptionFromOne();
        Assertions.assertEquals("1/4", firstRegistrationPage.getStepNumberTextLabel(), "1/4 should be shown on Second Registration Page");
    }
}
