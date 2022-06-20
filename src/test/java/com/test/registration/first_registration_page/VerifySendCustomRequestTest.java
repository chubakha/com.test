package com.test.registration.first_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifySendCustomRequestTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    void verifySendCustomRequest() {
        Faker faker = new Faker();
        String needHelpWithSomethingText = faker.name().fullName();
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElse(needHelpWithSomethingText)
                .clickNeedHelpWithSomethingElseSendButton();
        Assertions.assertEquals(needHelpWithSomethingText, firstRegistrationPage.getAddedNeedHelpWithSomethingElse(),
                String.format("'%s' should be shown", needHelpWithSomethingText));
    }
}
