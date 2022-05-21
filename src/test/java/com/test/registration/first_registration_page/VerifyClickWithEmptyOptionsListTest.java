package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyClickWithEmptyOptionsListTest extends PrepareRegistrationTestData {
    @Test
    void verifyClickWithEmptyOptionsList(){
        new FirstRegistrationPage().clickNextButton();
        Assertions.assertEquals("1/4", new FirstRegistrationPage().getStepNumberTextLabel(), "'1/4' should be shown");
    }
}
