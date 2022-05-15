package com.test.registration.first_registration_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyWhatDoYouNeedLegallySolvedTitleTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyWhatDoYouNeedLegallySolvedTitle(){
        Assertions.assertEquals("What do you need legally solved?", new FirstRegistrationPage().getWhatDoYouNeedLegallySolved(),"'What do you need legally solved?' should be shown");
    }
}
