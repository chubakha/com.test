package com.test.first_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyFirstPageRegistrationTitleTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyFirstPageRegistrationTitle(){
        Assertions.assertEquals("What do you need legally solved?", new FirstRegistrationPage().getWhatDoYouNeedLegallySolved(),"'What do you need legally solved?' should be shown");
    }
}
