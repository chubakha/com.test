package com.test.registration.first_registration_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyOneSelectedCheckboxPerSectionTest extends PrepareFirstRegistrationPageTestData {

    @Test
    void verifyOneSelectedCheckboxPerSection() {
        SecondRegistrationPage secondRegistrationPage =
                new FirstRegistrationPage()
                        .clickOneCheckboxInEverySection();

        secondRegistrationPage.getStepNumberTextLabel();
        Assertions.assertEquals("2/4", secondRegistrationPage.getStepNumberTextLabel(),"2/4 should be shown on Second Registration Page");
    }
}
