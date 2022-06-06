package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyOpeningTermsAndConditionsLinkTest extends PrepareRegistrationTestData {
    @Test
    void verifyOpeningTermsAndConditionsLink() {
        new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .clickTermsAndConditionsLink();
        System.out.println(new TermsAndConditionsOverlay().getTermsAndConditionsTitle());
    }
}