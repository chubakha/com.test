package com.test.registration.first_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifySendCustomRequestTest extends PrepareRegistrationTestData {
    @Test
    void verifySendCustomRequest() {
        Faker faker = new Faker();
        String needHelpWithSomethingText = faker.name().fullName();
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElseText(needHelpWithSomethingText)
                .clickNeedHelpWithSomethingElseSendButton();
        Assertions.assertEquals(needHelpWithSomethingText, firstRegistrationPage.getAddedNeedHelpWithSomethingElse(), String.format("'%s' should be shown", needHelpWithSomethingText));
    }
}
