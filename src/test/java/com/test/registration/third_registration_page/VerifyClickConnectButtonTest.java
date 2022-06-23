package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationSteps;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyClickConnectButtonTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_THIRD_REGISTRATION_PAGE)
    void verifyClickConnectButton() {
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton();
        Assertions.assertEquals(RegistrationSteps.REGISTRATION_STEP4.getValue(), fourthRegistrationPage.getStepNumber(),
                "'" + RegistrationSteps.REGISTRATION_STEP4.getValue() + "' should be shown");
    }

}
