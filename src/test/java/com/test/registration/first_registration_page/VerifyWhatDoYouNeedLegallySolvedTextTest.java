package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyWhatDoYouNeedLegallySolvedTextTest extends PrepareRegistrationTestData {
    @Test
    void verifyWhatDoYouNeedLegallySolvedTitle(){
        Assertions.assertEquals("What do you need legally solved?", new FirstRegistrationPage().getWhatDoYouNeedLegallySolved(),"'What do you need legally solved?' should be shown");
    }
}
