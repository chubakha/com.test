package com.test.first_registration_page;

import com.test.registration.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAddTextToNeedHelpWithSomethingElseTest extends PrepareFirstRegistrationPageTestData {
    //public String needhelpwithsomethingelseText = "my custom need";
    @Test
    void verifyAddedTextNeedHelpWithSomethingElse() {
        FirstRegistrationPage firstRegistrationPage =
                new FirstRegistrationPage();// добавить 3 методов ниже в одну строку нельзя?
        firstRegistrationPage.clickNeedHelpWithSomethingElseButton();
        firstRegistrationPage.setNeedHelpWithSomethingElseText();
        Assertions.assertEquals(firstRegistrationPage.needhelpwithsomethingelseText, firstRegistrationPage.getNeedHelpWithSomethingElseText(), "Added text should be equal to displayed");
    }
}
