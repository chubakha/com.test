package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.stream.Stream;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifySendFormWithPasswordFrom8To14SymbolsTest extends PrepareRegistrationTestData {
    @ParameterizedTest
    @MethodSource
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

    static Stream<String> verifySendFormWithPasswordFrom8To14Symbols(){
        faker = new Faker();
        return Stream.of(faker.internet().password(8,9),
                faker.internet().password(9,10),
                faker.internet().password(10,11),
                faker.internet().password(11,12),
                faker.internet().password(12,13),
                faker.internet().password(13,14),
                faker.internet().password(14,15));
    }

}
