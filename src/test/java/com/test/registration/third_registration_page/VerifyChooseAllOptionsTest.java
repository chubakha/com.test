package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyChooseAllOptionsTest extends PrepareRegistrationTestData {

    @Test
    void verifyChooseAllOptions() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectAllCheckboxInEverySection();
        String[] chosenListFirstPage = firstRegistrationPage.getSelectedOptions();
        firstRegistrationPage
                .clickEnabledNextButton()
                .clickNextButton();
        Assertions.assertArrayEquals(chosenListFirstPage, new ThirdRegistrationPage().getSecondColumnTable(),
                "Chosen options on first registration page should be equals shown option on third registration page");
    }
}
