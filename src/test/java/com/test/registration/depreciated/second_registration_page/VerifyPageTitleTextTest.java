package com.test.registration.depreciated.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyPageTitleTextTest extends PrepareRegistrationTestData {

    @Test
    void verifyPleaseCheckTheListOfTasksWhichShouldBeLegallySortedOutTest(){
        SecondRegistrationPage secondRegistrationPage = new FirstRegistrationPage()
                .selectOneCheckboxInEverySection()
                .clickEnabledNextButton();
        Assertions.assertEquals("Please check the list of tasks which should be legally sorted out",
                secondRegistrationPage.getPageTitle(),
                "'Please check the list of tasks which should be legally sorted out' should be shown");

    }
}