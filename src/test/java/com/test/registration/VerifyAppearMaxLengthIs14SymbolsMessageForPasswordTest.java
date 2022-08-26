package com.test.registration;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import com.test.registration.fourth_registration_page.ValidationErrorMessagesType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyAppearMaxLengthIs14SymbolsMessageForPasswordTest extends PrepareRegistrationTestData{

    @ParameterizedTest
    @MethodSource
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

    static Stream<String> verifyAppearMaxLengthIs14SymbolsMessageForPassword(){
        return Stream.of(faker.internet().password(15,16), faker.internet().password(16,17));
    }

}
