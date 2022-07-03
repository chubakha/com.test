package com.test.registration.depreciated.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationStepsType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyClickNextButtonWithoutChosenOptionTest extends PrepareRegistrationTestData {

    @Test
    void verifyClickNextButtonWithoutChosenOption() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickDisabledNextButton();
        Assertions.assertEquals(RegistrationStepsType.REGISTRATION_STEP1.getValue(), firstRegistrationPage.getStepNumber(),
                String.format("'%s' should be shown", RegistrationStepsType.REGISTRATION_STEP1.getValue()));
    }
}
