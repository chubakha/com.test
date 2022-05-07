package com.test.first_registration_page;

import com.codeborne.selenide.Condition;
import com.test.registration.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyNeedHelpWithSomethingElsePopupAppearedTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyNeedHelpWithSomethingElsePopupAppeared() {
        new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton();//чем отличается от "FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage().clickNeedHelpWithSomethingElseButton();"
        $x("//*[contains(@class, 'CustomModal_heading') and contains(text(), 'Create Custom Request')]").shouldBe(Condition.visible);
    }
}
