package com.test.registration.second_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VerifyDeleteAddedOptionFromFewTest extends PrepareSecondRegistrationPageTestData {
    @Test
    void verifyDeleteAddedOptionFromFew(){
        String deletingElement =
                new FirstRegistrationPage()
                        .choiceOneCheckboxInEverySection()
                        .deleteOneRandomChosenOptionFromFew();
        String[] chosenListAfterDeleting = new SecondRegistrationPage().getChosenOptions();
        Assertions.assertFalse(Arrays.asList(chosenListAfterDeleting).contains(deletingElement), "deletingElement shouldn't be in the chosen list");
    }
}
