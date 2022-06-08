package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class VerifyPasswordMore14SymbolsTest extends PrepareRegistrationTestData{
    @ParameterizedTest
    @MethodSource
    void VerifyPasswordMore14SymbolsTest(String password){
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
        Assertions.assertEquals(String.format("max length is 14 symbols (%s)", password.length()), fourthRegistrationPage.getFieldIsRequiredForPasswordField());
    }

    static Stream<String> VerifyPasswordMore14SymbolsTest(){
        List<String> passwords = new ArrayList<String>();
        Faker faker = new Faker();
        for (int i = 15; i <= 17; i++){
            passwords.add(faker.internet().password(i,i+1));
        }
        passwords.add(faker.internet().password(24,25));
        passwords.add(faker.internet().password(32,33));
        Stream stream = passwords.stream();
        return stream;
    }

}
