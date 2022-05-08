package com.test.first_registration_page;

import com.codeborne.selenide.Condition;
import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

import org.junit.jupiter.api.Test;

public class VerifyDeleteNeedHelpWithSomethingElseTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyDeleteNeedHelpWithSomethingElse() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage();
        firstRegistrationPage.clickNeedHelpWithSomethingElseButton();
        CreateCustomRequestOverlay createCustomRequestOverlay = new CreateCustomRequestOverlay().setNeedHelpWithSomethingElseText("my custom need");
        createCustomRequestOverlay.setNeedHelpWithSomethingElseText("my custom need");
        firstRegistrationPage.clickNeedHelpWithSomethingElseSendButton();
        firstRegistrationPage.deleteNeedHelpWithSomethingElseButton();
        $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]/div/div[1]").shouldBe(Condition.text("NEED HELP WITH SOMETHING ELSE?"));
    }
}
