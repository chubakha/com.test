package com.test.registration.second_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyPleaseCheckTheListOfTasksWhichShouldBeLegallySortedOutTest extends PrepareSecondRegistrationPageTestData {
    @Test
    void verifyPleaseCheckTheListOfTasksWhichShouldBeLegallySortedOutTest(){
        new FirstRegistrationPage().choiceOneCheckboxInEverySection();
        Assertions.assertEquals("Please check the list of tasks which should be legally sorted out",
                new SecondRegistrationPage().getPleaseCheckTheListOfTasksWhichShouldBeLegallySortedOut(),
                "'Please check the list of tasks which should be legally sorted out' should be shown");

    }
}
