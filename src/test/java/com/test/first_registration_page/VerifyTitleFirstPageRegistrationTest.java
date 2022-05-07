package com.test.first_registration_page;

import com.test.registration.FirstRegistrationPage;
import com.test.registration.WhatDoYouNeedLegallySolvedSections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyTitleFirstPageRegistrationTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyTitleFirstPageRegistration(){
        Assertions.assertEquals("What do you need legally solved?", new FirstRegistrationPage().getWhatDoYouNeedLegallySolved(),"'What do you need legally solved?' should be shown on First Registration Page");
    }

    /*@Test
    void test(){
            System.out.println(WhatDoYouNeedLegallySolvedSections.values()[1]);
    }*/
}
