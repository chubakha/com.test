package com.test.registration.depreciated.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationStepsType;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyDeleteOneChosenOptionFromOneTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_SECOND_REGISTRATION_PAGE)
    void verifyDeleteChosenOptionFromOne() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .deleteOneChosenOptionFromOne();
        Assertions.assertEquals(RegistrationStepsType.REGISTRATION_STEP1.getValue(), firstRegistrationPage.getStepNumber(),
                String.format("'%s' should be shown", RegistrationStepsType.REGISTRATION_STEP1.getValue()));
    }
}
