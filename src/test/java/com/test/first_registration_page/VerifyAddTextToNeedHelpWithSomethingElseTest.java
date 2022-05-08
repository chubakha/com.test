package com.test.first_registration_page;

import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;
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
        Assertions.assertEquals(needHelpWithSomethingText, createCustomRequestOverlay.getNeedHelpWithSomethingElseText(), "Added text should be equal to displayed");
    }
}
