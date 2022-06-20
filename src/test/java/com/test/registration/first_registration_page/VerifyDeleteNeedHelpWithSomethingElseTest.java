package com.test.registration.first_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyDeleteNeedHelpWithSomethingElseTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    void verifyDeleteNeedHelpWithSomethingElse() {
        String needHelpMessage = new Faker().name().fullName();
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElse(needHelpMessage)
                .clickNeedHelpWithSomethingElseSendButton()
                .deleteNeedHelpWithSomethingElse();
        Assertions.assertEquals(firstRegistrationPage.getNeedHelpWithSomethingElseTitle(), "NEED HELP WITH SOMETHING ELSE?",
                "'NEED HELP WITH SOMETHING ELSE?' should be shown");
    }
}
