package com.test.first_registration_page;

import com.codeborne.selenide.Condition;
import com.test.registration.FirstRegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class VerifySendNeedHelpWithSomethingTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifySendNeedHelpWithSomething(){
        FirstRegistrationPage firstRegistrationPage =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton();
        firstRegistrationPage.setNeedHelpWithSomethingElseText();
        firstRegistrationPage.clickNeedHelpWithSomethingElseSendButton();
        $x("//div[contains(@class, 'FirstStep_customRequestBlock')]/*/*[2]/div/span").shouldBe(Condition.text(firstRegistrationPage.needhelpwithsomethingelseText));
    }

}
