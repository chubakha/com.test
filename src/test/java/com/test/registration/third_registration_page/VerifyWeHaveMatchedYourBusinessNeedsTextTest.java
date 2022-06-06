package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyWeHaveMatchedYourBusinessNeedsTextTest extends PrepareRegistrationTestData {
    @Test
    void verifyWeHaveMatchedYourBusinessNeedsText() {
        ThirdRegistrationPage thirdRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton();
        Assertions.assertEquals("We have matched your business needs with the legal solutions.",
                new ThirdRegistrationPage().getWeHaveMatchedYourBusinessNeedsWithTheLegalSolutions(),
                "'We have matched your business needs with the legal solutions.' should be shown");
    }
}
