package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifySendCustomRequestTest extends PrepareRegistrationTestData {
    @Test
    void verifySendCustomRequest() {
        String needHelpWithSomethingText = "my custom need";
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElseText(needHelpWithSomethingText)
                .clickNeedHelpWithSomethingElseSendButton();
        Assertions.assertEquals(needHelpWithSomethingText, firstRegistrationPage.getAddedNeedHelpWithSomethingElse(), "'my custom need' should be shown");
    }
}
