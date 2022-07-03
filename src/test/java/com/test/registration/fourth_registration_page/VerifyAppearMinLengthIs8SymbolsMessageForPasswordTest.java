package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyAppearMinLengthIs8SymbolsMessageForPasswordTest extends PrepareRegistrationTestData{

    @ParameterizedTest(name = "{index} - password is {0}")
    @ValueSource(strings = { "1", "12", "123", "1234", "12345", "123456", "1234567" })
    //@MethodSource
    void verifyAppearMinLengthIs8SymbolsMessageForPassword(String password){
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(String.format(ValidationErrorMessagesType.MIN_LENGTH_IS_8_SYMBOLS.getValue(), password.length()),
                fourthRegistrationPage.getValidationMessageForPasswordField(),
                String.format("'%s' should be shown next to Password Field",
                        String.format(ValidationErrorMessagesType.MIN_LENGTH_IS_8_SYMBOLS.getValue(), password.length())));
        Assertions.assertEquals(String.format(ValidationErrorMessagesType.MIN_LENGTH_IS_8_SYMBOLS.getValue(), password.length()),
                fourthRegistrationPage.getValidationMessageForRepeatPasswordField(),
                String.format("'%s' should be shown next to Repeat Password Field",
                        String.format(ValidationErrorMessagesType.MIN_LENGTH_IS_8_SYMBOLS.getValue(), password.length())));
    }

    /*static List<String> verifyPasswordFrom1To7Symbols(){
        List<String> passwords = new ArrayList();
        passwords.add(String.valueOf(faker.number().numberBetween(1,9)));
        passwords.add(String.valueOf(faker.number().numberBetween(10,99)));
        passwords.add(String.valueOf(faker.number().numberBetween(100,999)));
        passwords.add(String.valueOf(faker.number().numberBetween(1000,9999)));
        passwords.add(String.valueOf(faker.number().numberBetween(10000,99999)));
        passwords.add(String.valueOf(faker.number().numberBetween(100000,999999)));
        passwords.add(String.valueOf(faker.number().numberBetween(1000000,9999999)));
        return passwords;
    }*/

}
