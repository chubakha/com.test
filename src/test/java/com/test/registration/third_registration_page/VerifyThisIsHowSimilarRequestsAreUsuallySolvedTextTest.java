package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyThisIsHowSimilarRequestsAreUsuallySolvedTextTest extends PrepareRegistrationTestData {
    @Test
    void verifyThisIsHowSimilarRequestsAreUsuallySolvedText(){
        new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton();
        //sleep(1000);
        ThirdRegistrationPage thirdRegistrationPage =
                new SecondRegistrationPage()
                    .clickNextButton();
        Assertions.assertEquals("This is how similar requests are usually solved",
                thirdRegistrationPage.getThisIsHowSimilarRequestsAreUsuallySolved(),
                "'This is how similar requests are usually solved' should be shown");
    }

}
