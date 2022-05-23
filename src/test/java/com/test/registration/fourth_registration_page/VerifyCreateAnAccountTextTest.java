package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyCreateAnAccountTextTest extends PrepareRegistrationTestData {
    @Test
    void verifyCreateAnAccountText() {
        new FirstRegistrationPage()
                .choiceOneRandomCheckbox();
        sleep(1000);
        FourthRegistrationPage fourthRegistrationPage =
                new SecondRegistrationPage()
                        .clickNextButton()
                        .clickConnectButton();
        Assertions.assertEquals("Create an account",
                fourthRegistrationPage.getCreateAnAccount(),
                "'Create an account' should be shown");
    }
}
