package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationSteps;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyReturnOnPreviousPageTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_SECOND_REGISTRATION_PAGE)
    void verifyReturnToPreviousPage() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickBackButton();
        Assertions.assertEquals(RegistrationSteps.REGISTRATION_STEP1.getValue(), firstRegistrationPage.getStepNumber(),
                "'" + RegistrationSteps.REGISTRATION_STEP1.getValue() + "' should be shown");
    }
}
