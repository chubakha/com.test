package com.test.registration.depreciated.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import com.test.registration.depreciated.third_page_registration.ThirdRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyChooseAllOptionsTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_THIRD_REGISTRATION_PAGE)
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
