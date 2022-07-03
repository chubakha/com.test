package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationStepsType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyCreateAnAccountTextTest extends PrepareRegistrationTestData {

    @Test
    void verifyCreateAnAccountText() {
        String fourthRegistrationPage = new FourthRegistrationPage()
                .getPageTitle();
        Assertions.assertEquals(RegistrationStepsType.REGISTRATION_STEP4.getValue(), fourthRegistrationPage,
                String.format("'%s' should be shown", RegistrationStepsType.REGISTRATION_STEP4.getValue()));
    }
}
