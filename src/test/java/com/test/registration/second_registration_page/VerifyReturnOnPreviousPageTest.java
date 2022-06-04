package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyReturnOnPreviousPageTest extends PrepareRegistrationTestData {
    @Test
    void verifyReturnToPreviousPage() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickBackButton();
        Assertions.assertEquals("1/4", firstRegistrationPage.getStepNumber(), "1/4 should be shown");
    }
}
