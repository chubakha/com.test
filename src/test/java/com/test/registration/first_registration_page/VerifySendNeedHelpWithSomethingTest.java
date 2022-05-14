package com.test.registration.first_registration_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifySendNeedHelpWithSomethingTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifySendNeedHelpWithSomething() {
        String needHelpWithSomethingText = "my custom need";
        FirstRegistrationPage firstRegistrationPage =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton()
                        .setNeedHelpWithSomethingElseText(needHelpWithSomethingText)
                        .clickNeedHelpWithSomethingElseSendButton();
        Assertions.assertEquals(firstRegistrationPage.getAddedNeedHelpWithSomethingElseText(), needHelpWithSomethingText, "'my custom need' should be shown");
    }
}
