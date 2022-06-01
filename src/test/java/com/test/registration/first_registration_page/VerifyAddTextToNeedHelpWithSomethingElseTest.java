package com.test.registration.first_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAddTextToNeedHelpWithSomethingElseTest extends PrepareRegistrationTestData {
    @Test
    void verifyAddedTextNeedHelpWithSomethingElse() {
        Faker faker = new Faker();
        String needHelpWithSomethingText = faker.name().fullName();
        CreateCustomRequestOverlay createCustomRequestOverlay = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElseText(needHelpWithSomethingText);
        Assertions.assertEquals(needHelpWithSomethingText, createCustomRequestOverlay.getNeedHelpWithSomethingElseText(), String.format("'%s' should be shown", needHelpWithSomethingText));
    }
}
