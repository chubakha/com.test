package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Attachment;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyIncorrectEmailAddressTest extends PrepareRegistrationTestData {

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }

    @ParameterizedTest(name = "{index} - testing email: {0}")
    @ValueSource(strings = {"testgmail.com", "test@@gmail.com", "test@gmailcom", "test@gmail", "test@gmail,com", "gmail.com", "test@.com", "test@com", "test@gmail.c", "test@gmail.comcom", "test@gmail.com.com", "почта@gmail.com", "test@гмаил.com", ".test@gmail.com", "test.@gmail.com", "test!@gmail.com", "test?@gmail.com"})
    void verifyIncorrectEmailAddress(String email) {
        String password = faker.internet().password(8, 15);
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(email)
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertTrue(fourthRegistrationPage.isFieldIsRequiredForEmailFieldShown());

    }
}
