package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifySendFormWithPasswordFrom8To14SymbolsTest extends PrepareRegistrationTestData {

    @ParameterizedTest
    @ValueSource(strings = {"12345678", "123456789", "1234567891", "12345678912", "123456789123", "1234567891234"})
    //@MethodSource("verifyPasswordFrom8To14Symbols")
    void verifySendFormWithPasswordFrom8To14Symbols(String password) {
        ConfirmYourAccountOverlay confirmYourAccountOverlay = new FourthRegistrationPage()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveCreateAccountButton();
        Assertions.assertEquals("Confirm your account", confirmYourAccountOverlay.getPageTitle(),
                "'Confirm your account' page should be shown");
    }

    /*static Stream<String> verifyPasswordFrom8To14Symbols(){
        List<String> passwords = new ArrayList<String>();
        for (int i = 8; i <= 14; i++){
            passwords.add(faker.internet().password(i,i+1));
        }
        return Stream.of("alex", "brian");
    }*/

    /*static Stream<String> verifyPasswordFrom8To14Symbols(){
        List<String> passwords = new ArrayList();
        for (int i = 8; i <= 14; i++){
            passwords.add(faker.internet().password(i,i+1));
        }
        return Stream.of("alex", "brian");
    }*/

}
