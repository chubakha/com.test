package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyOpenTermsAndConditionsLinkTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FOURTH_REGISTRATION_PAGE)
    void verifyOpenTermsAndConditionsLink() {
        AttachmentDocumentsOverlay attachmentDocumentsOverlay = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .clickTermsAndConditionsLink();
        Assertions.assertEquals("https://drive.google.com/file/d/1yOBnDvIqXjxaDy4NPc7idvXUMEg0WN-2/view",
                attachmentDocumentsOverlay.getAttachmentDocumentUrl(),
                "Document link should be 'https://drive.google.com/file/d/1yOBnDvIqXjxaDy4NPc7idvXUMEg0WN-2/view'");
        attachmentDocumentsOverlay.closeAttachmentDocumentTab();
    }
}
