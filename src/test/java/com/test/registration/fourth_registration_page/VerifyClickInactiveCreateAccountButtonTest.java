package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationStepsType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyClickInactiveCreateAccountButtonTest extends PrepareRegistrationTestData {

    @Test
    void verifyClickInactiveCreateAccountButton() {
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(RegistrationStepsType.REGISTRATION_STEP4.getValue(), fourthRegistrationPage.getPageTitle(),
                String.format("'%s' page number should be shown", RegistrationStepsType.REGISTRATION_STEP4.getValue()));
    }
}
