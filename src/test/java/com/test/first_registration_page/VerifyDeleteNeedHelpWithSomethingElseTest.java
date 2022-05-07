package com.test.first_registration_page;

import com.codeborne.selenide.Condition;
import com.test.registration.FirstRegistrationPage;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

import org.junit.jupiter.api.Test;

public class VerifyDeleteNeedHelpWithSomethingElseTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyDeleteNeedHelpWithSomethingElse() {
        FirstRegistrationPage firstRegistrationPage =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton();
        firstRegistrationPage.setNeedHelpWithSomethingElseText();
        firstRegistrationPage.clickNeedHelpWithSomethingElseSendButton();
        firstRegistrationPage.deleteNeedHelpWithSomethingElseButton();
        sleep(3000);
        $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]/div/div[1]").shouldBe(Condition.text("NEED HELP WITH SOMETHING ELSE?"));
    }
}
