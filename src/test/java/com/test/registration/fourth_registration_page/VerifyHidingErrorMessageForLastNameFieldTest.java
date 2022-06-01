package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyHidingErrorMessageForLastNameFieldTest extends PrepareRegistrationTestData {
    @Test//тут
    void verifyHidingErrorMessageForLastNameField() {
        new FirstRegistrationPage()
                .selectOneRandomOptionAndRedirectOnSecondRegistrationPage();
        sleep(2000);
        FourthRegistrationPage fourthRegistrationPage = new SecondRegistrationPage()
                .clickNextButton()
                .clickConnectButton()
                .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setLastNameField(LAST_NAME_REGISTRATION_TEST_CLIENT)
                .clickInactiveCreateAccountButton();
        Assertions.assertFalse(fourthRegistrationPage.isLastNameFieldRequiredErrorMessageShown(),
                "'field is required' should not be shown below LastName field");
    }
}
