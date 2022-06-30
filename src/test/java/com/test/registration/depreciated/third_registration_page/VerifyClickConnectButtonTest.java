package com.test.registration.depreciated.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationStepsType;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
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
        Assertions.assertEquals(RegistrationStepsType.REGISTRATION_STEP4.getValue(), fourthRegistrationPage.getStepNumber(),
                String.format("'%s' should be shown", RegistrationStepsType.REGISTRATION_STEP4.getValue()));
    }

}
