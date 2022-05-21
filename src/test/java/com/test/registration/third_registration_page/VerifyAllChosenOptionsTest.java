package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAllChosenOptionsTest extends PrepareRegistrationTestData {
    @Test
    void verifyAllChosenOptions() {
        String[] chosenListFirstPage =
                new FirstRegistrationPage()
                        .selectAllCheckboxInEverySection()
                        .getAllChosenOptionsOriginal();
        new FirstRegistrationPage().clickNextButtonToSecondPage();
        sleep(2000);
        new SecondRegistrationPage().clickNextButton();
        sleep(2000);
        String[] chosenListSecondColumnTable =
                new ThirdRegistrationPage().getSecondColumnTable();
        Assertions.assertArrayEquals(chosenListFirstPage, chosenListSecondColumnTable,
                "Chosen options on first registration page should be equals shown option on third registration page");
    }
}
