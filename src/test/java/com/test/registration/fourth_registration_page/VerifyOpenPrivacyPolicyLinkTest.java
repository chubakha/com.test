package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyOpenPrivacyPolicyLinkTest extends PrepareRegistrationTestData {
    @Test
    void verifyOpenPrivacyPolicyLink() {
        AttachmentDocumentsOverlay attachmentDocumentsOverlay = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .clickPrivacyPolicyLink();
        Assertions.assertEquals("https://drive.google.com/file/d/1SjuP_NyIPlz2aHcfhCAGYOOOgUylZNWe/view", attachmentDocumentsOverlay.getAttachmentDocumentUrl(), "Document link should be 'https://drive.google.com/file/d/1SjuP_NyIPlz2aHcfhCAGYOOOgUylZNWe/view'");
    }
}
