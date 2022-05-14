package com.test.registration.first_registration_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAllSelectedCheckboxesTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyAllSelectedCheckboxes() {
        SecondRegistrationPage secondRegistrationPage =
                new FirstRegistrationPage()
                        .clickAllCheckboxInEverySection();

        secondRegistrationPage.getStepNumberTextLabel();
        Assertions.assertEquals("2/4", secondRegistrationPage.getStepNumberTextLabel(),"2/4 should be shown on Second Registration Page");
    }
}
