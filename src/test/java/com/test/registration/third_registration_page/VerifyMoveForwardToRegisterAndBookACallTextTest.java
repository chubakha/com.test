package com.test.registration.third_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyMoveForwardToRegisterAndBookACallTextTest extends PrepareThirdRegistrationPageTestData {
    @Test
    void verifyMoveForwardToRegisterAndBookACallText(){
        new FirstRegistrationPage()
                .choiceOneRandomCheckbox();
        sleep(1000);
        new SecondRegistrationPage().clickNextButton();
        Assertions.assertEquals("Move forward to register and book a call with lawyer to discuss the suggested legal solutions",
                new ThirdRegistrationPage().getMoveForwardToRegisterAndBookACall(),
                "'Move forward to register and book a call with lawyer to discuss the suggested legal solutions' should be shown");
    }
}
