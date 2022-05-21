package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAllSelectedCheckboxesTest extends PrepareRegistrationTestData {
    @Test
    void verifyAllSelectedCheckboxes() {
        SecondRegistrationPage secondRegistrationPage =
                new FirstRegistrationPage()
                        .choiceAllCheckboxInEverySection();
        Assertions.assertEquals("2/4", secondRegistrationPage.getStepNumberTextLabel(),"2/4 should be shown");
    }
}
