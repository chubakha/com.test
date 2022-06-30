package com.test.registration.depreciated.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import com.test.registration.depreciated.third_page_registration.ThirdRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyMoveForwardToRegisterAndBookACallTextTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_THIRD_REGISTRATION_PAGE)
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
