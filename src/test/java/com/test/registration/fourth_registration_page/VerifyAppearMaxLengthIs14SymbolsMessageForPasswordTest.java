package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyAppearMaxLengthIs14SymbolsMessageForPasswordTest extends PrepareRegistrationTestData{

    @ParameterizedTest
    @ValueSource(strings = { "123456789123456", "1234567891234567", "12345678912345678" })
    //@MethodSource
    void verifyAppearMaxLengthIs14SymbolsMessageForPassword(String password){
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(String.format(ValidationErrorMessagesType.MAX_LENGTH_IS_14_SYMBOLS.getValue(), password.length()),
                fourthRegistrationPage.getValidationMessageForPasswordField(),
                String.format("'%s' should be shown next to Password Field",
                        String.format(ValidationErrorMessagesType.MAX_LENGTH_IS_14_SYMBOLS.getValue(), password.length())));
        Assertions.assertEquals(String.format(ValidationErrorMessagesType.MAX_LENGTH_IS_14_SYMBOLS.getValue(), password.length()),
                fourthRegistrationPage.getValidationMessageForRepeatPasswordField(),
                String.format("'%s' should be shown next to Repeat Password Field",
                        String.format(ValidationErrorMessagesType.MAX_LENGTH_IS_14_SYMBOLS.getValue(), password.length())));
    }

    /*static Stream<String> VerifyPasswordMore14SymbolsTest(){
        List<String> passwords = new ArrayList<String>();
        for (int i = 15; i <= 17; i++){
            passwords.add(faker.internet().password(i,i+1));
        }
        passwords.add(faker.internet().password(24,25));
        passwords.add(faker.internet().password(32,33));
        Stream stream = passwords.stream();
        return stream;
    }*/

}
