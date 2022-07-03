package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyOpenPrivacyPolicyLinkTest extends PrepareRegistrationTestData {

    @Test
    void verifyOpenPrivacyPolicyLink() {
        AttachmentDocumentsOverlay attachmentDocumentsOverlay = new FourthRegistrationPage()
                .clickPrivacyPolicyLink();
        Assertions.assertEquals(DocumentLinksType.PRIVACY_POLICY.getValue(),
                attachmentDocumentsOverlay.getAttachmentDocumentUrl(),
                String.format("Privacy Policy link should be '%s'", DocumentLinksType.PRIVACY_POLICY.getValue()));
        attachmentDocumentsOverlay.closeAttachmentDocumentTab();
    }
}
