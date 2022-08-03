package com.test.registration.fourth_registration_page;

import com.codeborne.selenide.WebDriverRunner;
import com.test.ScreenshotExtension;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Attachment;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ScreenshotException;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
@ExtendWith(ScreenshotExtension.class)
public class VerifyDisappearFieldIsRequiredMessageForEmailFieldTest extends PrepareRegistrationTestData {

    @Test
    @Attachment(value = "Page screenshot", type = "image/png")
    void verifyDisappearFieldIsRequiredMessageForEmailField() {
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setEmailField(faker.internet().emailAddress())
                .clickInactiveCreateAccountButton();
        Assertions.assertFalse(fourthRegistrationPage.isFieldIsRequiredForEmailFieldShown(),
                String.format("'%s' should not be shown next to Email field", ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue()));
    }
}
