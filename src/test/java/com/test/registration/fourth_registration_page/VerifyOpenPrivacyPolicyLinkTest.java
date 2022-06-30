package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyOpenPrivacyPolicyLinkTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FOURTH_REGISTRATION_PAGE)
    void verifyOpenPrivacyPolicyLink() {
        AttachmentDocumentsOverlay attachmentDocumentsOverlay = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .clickPrivacyPolicyLink();
        Assertions.assertEquals("https://drive.google.com/file/d/1SjuP_NyIPlz2aHcfhCAGYOOOgUylZNWe/view",
                attachmentDocumentsOverlay.getAttachmentDocumentUrl(),
                "Document link should be 'https://drive.google.com/file/d/1SjuP_NyIPlz2aHcfhCAGYOOOgUylZNWe/view'");
        attachmentDocumentsOverlay.closeAttachmentDocumentTab();
    }
}
