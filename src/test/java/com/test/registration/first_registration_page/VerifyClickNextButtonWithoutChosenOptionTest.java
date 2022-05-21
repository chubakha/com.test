package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyClickNextButtonWithoutChosenOptionTest extends PrepareRegistrationTestData {
    @Test
    void verifyClickNextButtonWithoutChosenOption(){
        FirstRegistrationPage firstRegistrationPage =
                new FirstRegistrationPage()
                        .clickNextButtonWithoutRedirection();
        Assertions.assertEquals("1/4", firstRegistrationPage.getStepNumberTextLabel(), "1/4 should be shown");
    }
}
