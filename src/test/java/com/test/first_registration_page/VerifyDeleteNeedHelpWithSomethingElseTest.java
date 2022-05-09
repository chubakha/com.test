package com.test.first_registration_page;

import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
///////////???????????
public class VerifyDeleteNeedHelpWithSomethingElseTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyDeleteNeedHelpWithSomethingElse() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage();
        firstRegistrationPage.clickNeedHelpWithSomethingElseButton();
        CreateCustomRequestOverlay createCustomRequestOverlay =
                new CreateCustomRequestOverlay()
                        .setNeedHelpWithSomethingElseText("my custom need")
                        .clickNeedHelpWithSomethingElseSendButton();
        firstRegistrationPage.deleteNeedHelpWithSomethingElseButton();
        Assertions.assertEquals(firstRegistrationPage.getNeedHelpWithSomethingElseText(), "NEED HELP WITH SOMETHING ELSE?", "'NEED HELP WITH SOMETHING ELSE?' should be shown");
    }
}
