package com.test.registration.depreciated.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationStepsType;
import com.test.registration.depreciated.second_registration_page.SecondRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifySelectOneOptionPerSectionTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FIRST_REGISTRATION_PAGE)
    void verifySelectOneOptionPerSection() {
        SecondRegistrationPage secondRegistrationPage = new FirstRegistrationPage()
                .selectOneCheckboxInEverySection()
                .clickEnabledNextButton();
        Assertions.assertEquals(RegistrationStepsType.REGISTRATION_STEP2.getValue(), secondRegistrationPage.getStepNumber(),
                String.format("'%s' should be shown", RegistrationStepsType.REGISTRATION_STEP2.getValue()));
    }
}
