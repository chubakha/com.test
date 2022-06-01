package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyDeleteNeedHelpWithSomethingElseTest extends PrepareRegistrationTestData {
    @Test
    void verifyDeleteNeedHelpWithSomethingElse() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElseText("my custom need")
                .clickNeedHelpWithSomethingElseSendButton()
                .deleteNeedHelpWithSomethingElse();
        Assertions.assertEquals(firstRegistrationPage.getNeedHelpWithSomethingElseTitle(), "NEED HELP WITH SOMETHING ELSE?", "'NEED HELP WITH SOMETHING ELSE?' should be shown");
    }
}
