package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyMoveForwardToRegisterAndBookACallTextTest extends PrepareRegistrationTestData {

    @Test
    void verifyMoveForwardToRegisterAndBookACallText() {
        ThirdRegistrationPage thirdRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton();
        Assertions.assertEquals("Move forward to register and book a call with lawyer to discuss the suggested legal solutions",
                thirdRegistrationPage.getMoveForwardToRegisterAndBookACall(),
                "'Move forward to register and book a call with lawyer to discuss the suggested legal solutions' should be shown");
    }
}
