package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyThisIsHowSimilarRequestsAreUsuallySolvedTextTest extends PrepareRegistrationTestData {

    @Test
    void verifyThisIsHowSimilarRequestsAreUsuallySolvedText(){
        ThirdRegistrationPage thirdRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton();
        Assertions.assertEquals("This is how similar requests are usually solved",
                thirdRegistrationPage.getPageTitle(),
                "'This is how similar requests are usually solved' should be shown");
    }

}
