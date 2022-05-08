package com.test.first_registration_page;

import com.codeborne.selenide.Condition;
import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class VerifySendNeedHelpWithSomethingTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifySendNeedHelpWithSomething(){
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage();
        firstRegistrationPage.clickNeedHelpWithSomethingElseButton();
        CreateCustomRequestOverlay createCustomRequestOverlay = new CreateCustomRequestOverlay();
        createCustomRequestOverlay.setNeedHelpWithSomethingElseText("my custom need");
        firstRegistrationPage.clickNeedHelpWithSomethingElseSendButton();
        $x("//div[contains(@class, 'FirstStep_customRequestBlock')]/*/*[2]/div/span").shouldBe(Condition.text("my custom need"));
    }

}
