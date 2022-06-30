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
import java.util.stream.Stream;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyPasswordMore14SymbolsTest extends PrepareRegistrationTestData{

    @Disabled
    @ParameterizedTest
    @MethodSource
    @Epic(value = STEP_FOURTH_REGISTRATION_PAGE)
    void VerifyPasswordMore14SymbolsTest(String password){
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
        Assertions.assertEquals(String.format("max length is 14 symbols (%s)", password.length()),
                fourthRegistrationPage.getFieldIsRequiredForPasswordField());
    }

    static Stream<String> VerifyPasswordMore14SymbolsTest(){
        List<String> passwords = new ArrayList<String>();
        for (int i = 15; i <= 17; i++){
            passwords.add(faker.internet().password(i,i+1));
        }
        passwords.add(faker.internet().password(24,25));
        passwords.add(faker.internet().password(32,33));
        Stream stream = passwords.stream();
        return stream;
    }

}
