package com.test.registration.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyChooseOneOptionsTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_THIRD_REGISTRATION_PAGE)
    void verifyChooseOneOptions() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption();
        String[] chosenListFirstPage = firstRegistrationPage.getSelectedOptions();
        firstRegistrationPage
                .clickEnabledNextButton()
                .clickNextButton();
        Assertions.assertArrayEquals(chosenListFirstPage, new ThirdRegistrationPage().getSecondColumnTable(),
                "Chosen option on first registration page should be equals shown option on third registration page");
    }
}
