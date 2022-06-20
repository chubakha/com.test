package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyReturnToPreviousPageTest extends PrepareRegistrationTestData {

    @Test
    void verifyReturnToPreviousPage(){
        SecondRegistrationPage secondRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickBackButton();
        Assertions.assertEquals("2/4", secondRegistrationPage.getStepNumber(), "2/4 should be shown");
    }
}
