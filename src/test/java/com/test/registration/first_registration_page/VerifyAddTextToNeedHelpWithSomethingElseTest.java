package com.test.registration.first_registration_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAddTextToNeedHelpWithSomethingElseTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyAddedTextNeedHelpWithSomethingElse() {
        String needHelpWithSomethingText = "my custom need";
        CreateCustomRequestOverlay createCustomRequestOverlay =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton()
                        .setNeedHelpWithSomethingElseText(needHelpWithSomethingText);
        Assertions.assertEquals(needHelpWithSomethingText, createCustomRequestOverlay.getNeedHelpWithSomethingElseText(), "'my custom need' should be equal to displayed");
    }
}
