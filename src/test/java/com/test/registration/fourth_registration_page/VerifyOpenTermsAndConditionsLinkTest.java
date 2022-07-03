package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import com.test.registration.fourth_registration_page.AttachmentDocumentsOverlay;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyOpenTermsAndConditionsLinkTest extends PrepareRegistrationTestData {

    @Test
    void verifyOpenTermsAndConditionsLink() {
        AttachmentDocumentsOverlay attachmentDocumentsOverlay = new FourthRegistrationPage()
                .clickTermsAndConditionsLink();
        Assertions.assertEquals(DocumentLinksType.TERMS_CONDITIONS.getValue(),
                attachmentDocumentsOverlay.getAttachmentDocumentUrl(),
                String.format("Term Conditions link should be '%s'", DocumentLinksType.TERMS_CONDITIONS.getValue()));
        attachmentDocumentsOverlay.closeAttachmentDocumentTab();
    }
}
