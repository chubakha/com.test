package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VerifyDeleteChosenOptionFromFewTest extends PrepareRegistrationTestData {
    @Test
    void verifyDeleteChosenOptionFromFew(){
        String deletingElement =
                new FirstRegistrationPage()
                        .choiceOneCheckboxInEverySection()
                        .deleteOneChosenOptionFromFew();
        String[] chosenListAfterDeleting = new SecondRegistrationPage().getAllChosenOptions();
        Assertions.assertFalse(Arrays.asList(chosenListAfterDeleting).contains(deletingElement), "deletingElement shouldn't be in the chosen list");
    }
}
