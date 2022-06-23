package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyClickNextButtonWithoutChosenOptionTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FIRST_REGISTRATION_PAGE)
    void verifyClickNextButtonWithoutChosenOption() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickDisabledNextButton();
        Assertions.assertEquals(RegistrationSteps.REGISTRATION_STEP1.getValue(), firstRegistrationPage.getStepNumber(),
                "'" + RegistrationSteps.REGISTRATION_STEP1.getValue() + "' should be shown");
    }
}
