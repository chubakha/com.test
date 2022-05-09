package com.test.first_registration_page;

import com.codeborne.selenide.Condition;
import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyDeleteNeedHelpWithSomethingElseTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyDeleteNeedHelpWithSomethingElse() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage();
        firstRegistrationPage.clickNeedHelpWithSomethingElseButton();
        CreateCustomRequestOverlay createCustomRequestOverlay = new CreateCustomRequestOverlay().setNeedHelpWithSomethingElseText("my custom need");
        createCustomRequestOverlay.setNeedHelpWithSomethingElseText("my custom need");
        createCustomRequestOverlay.clickNeedHelpWithSomethingElseSendButton();
        firstRegistrationPage.deleteNeedHelpWithSomethingElseButton();
        Assertions.assertEquals(firstRegistrationPage.getNeedHelpWithSomethingElseText(), "NEED HELP WITH SOMETHING ELSE?", "'NEED HELP WITH SOMETHING ELSE?' should be shown");
    }
}
