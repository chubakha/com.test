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
public class VerifyPasswordFrom8To14SymbolsTest extends PrepareRegistrationTestData{

    @Disabled
    @ParameterizedTest
    @MethodSource
    @Epic(value = STEP_FOURTH_REGISTRATION_PAGE)
    void verifyPasswordFrom8To14Symbols(String password){
        ConfirmYourAccountOverlay confirmYourAccountOverlay = new FirstRegistrationPage()
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
                .clickActiveCreateAccountButton();
        Assertions.assertEquals("Confirm your account", confirmYourAccountOverlay.getPageTitle(), "'Confirm your account' should be shown");
    }

    static Stream<String> verifyPasswordFrom8To14Symbols(){
        List<String> passwords = new ArrayList<String>();
        for (int i = 8; i <= 14; i++){
            passwords.add(faker.internet().password(i,i+1));
        }
        Stream stream = passwords.stream();
        return stream;
    }

}
