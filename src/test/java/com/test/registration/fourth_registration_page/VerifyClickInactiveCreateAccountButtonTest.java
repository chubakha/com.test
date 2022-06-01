package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyClickInactiveCreateAccountButtonTest extends PrepareRegistrationTestData {
    @Test
    void verifyClickInactiveCreateAccountButton() {
        new FirstRegistrationPage()
                .selectOneRandomOptionAndRedirectOnSecondRegistrationPage();
        sleep(1000);
        FourthRegistrationPage fourthRegistrationPage =
                new SecondRegistrationPage()
                        .clickNextButton()
                        .clickConnectButton()
                        .clickInactiveCreateAccountButton();
        Assertions.assertEquals("4/4", fourthRegistrationPage.getStepNumberTextLabel(), "'4/4' should be shown");
    }
}
