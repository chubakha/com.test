package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyPasswordFrom1To7SymbolsTest extends PrepareRegistrationTestData{

    @Disabled
    @ParameterizedTest
    @MethodSource
    @Epic(value = STEP_FOURTH_REGISTRATION_PAGE)
    void verifyPasswordFrom1To7Symbols(String password){
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
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(String.format("min length is 8 symbols (%s)", password.length()),
                fourthRegistrationPage.getFieldIsRequiredForPasswordField());
    }

    static List<String> verifyPasswordFrom1To7Symbols(){
        List<String> passwords = new ArrayList();
        passwords.add(String.valueOf(faker.number().numberBetween(1,9)));
        passwords.add(String.valueOf(faker.number().numberBetween(10,99)));
        passwords.add(String.valueOf(faker.number().numberBetween(100,999)));
        passwords.add(String.valueOf(faker.number().numberBetween(1000,9999)));
        passwords.add(String.valueOf(faker.number().numberBetween(10000,99999)));
        passwords.add(String.valueOf(faker.number().numberBetween(100000,999999)));
        passwords.add(String.valueOf(faker.number().numberBetween(1000000,9999999)));
        return passwords;
    }

}
