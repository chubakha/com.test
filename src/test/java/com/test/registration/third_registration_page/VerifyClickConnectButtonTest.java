package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyClickConnectButtonTest extends PrepareRegistrationTestData {
    @Test
    void verifyClickConnectButton() {
        new FirstRegistrationPage().choiceOneRandomCheckbox();
        sleep(2000);
        new SecondRegistrationPage().clickNextButton();
        sleep(1000);
        FourthRegistrationPage fourthRegistrationPage =
                new ThirdRegistrationPage()
                        .clickConnectButton();
        Assertions.assertEquals("4/4", fourthRegistrationPage.getStepNumberTextLabel(), "'4/4' should be shown");
    }

}
