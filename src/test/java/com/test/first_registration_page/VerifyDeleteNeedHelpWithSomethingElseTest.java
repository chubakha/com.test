package com.test.first_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyDeleteNeedHelpWithSomethingElseTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyDeleteNeedHelpWithSomethingElse() {
        FirstRegistrationPage firstRegistrationPage =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton()
                        .setNeedHelpWithSomethingElseText("my custom need")
                        .clickNeedHelpWithSomethingElseSendButton()
                        .deleteNeedHelpWithSomethingElseButton();
        Assertions.assertEquals(firstRegistrationPage.getNeedHelpWithSomethingElseText(), "NEED HELP WITH SOMETHING ELSE?", "'NEED HELP WITH SOMETHING ELSE?' should be shown");
    }
}
