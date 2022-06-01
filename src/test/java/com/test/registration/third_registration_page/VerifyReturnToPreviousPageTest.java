package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyReturnToPreviousPageTest extends PrepareRegistrationTestData {
    @Test
    void verifyReturnToPreviousPage(){
        new FirstRegistrationPage()
                        .selectOneRandomOptionAndRedirectOnSecondRegistrationPage();
        sleep(1000);
        new SecondRegistrationPage()
                .clickNextButton();
        sleep(1000);
        SecondRegistrationPage secondRegistrationPage =
                new ThirdRegistrationPage()
                        .clickBackButton();
        Assertions.assertEquals("2/4", secondRegistrationPage.getRegistrationPageNumber(), "2/4 should be shown");
    }
}
