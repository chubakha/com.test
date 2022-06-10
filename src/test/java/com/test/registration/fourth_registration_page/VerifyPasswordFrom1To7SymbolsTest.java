package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class VerifyPasswordFrom1To7SymbolsTest extends PrepareRegistrationTestData{
    @Disabled
    @ParameterizedTest
    @MethodSource
    void verifyPasswordFrom1To7Symbols(String password){
        Faker faker = new Faker();
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveCreateAccountButton();
        Assertions.assertEquals(String.format("min length is 8 symbols (%s)", password.length()), fourthRegistrationPage.getFieldIsRequiredForPasswordField());
    }

    static Stream<String> verifyPasswordFrom1To7Symbols(){
        List<String> passwords = new ArrayList<String>();
        Faker faker = new Faker();
        for (int i = 1; i <= 7; i++){
            passwords.add(faker.internet().password(i,i+1));
        }
        Stream stream = passwords.stream();
        return stream;
    }

}
