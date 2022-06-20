package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyClickConnectButtonTest extends PrepareRegistrationTestData {

    @Test
    void verifyClickConnectButton() {
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton();
        Assertions.assertEquals("4/4", fourthRegistrationPage.getStepNumber(), "'4/4' should be shown");
    }

}
