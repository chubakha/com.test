package com.test.registration;

import com.test.registration.fourth_registration_page.AttachmentDocumentsOverlay;
import com.test.registration.fourth_registration_page.DocumentLinksType;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyOpenTermsAndConditionsLinkTest extends PrepareRegistrationTestData {

    @Test
    void verifyOpenTermsAndConditionsLink() {
        AttachmentDocumentsOverlay attachmentDocumentsOverlay = new FourthRegistrationPage()
                .clickTermsAndConditionsLink();
        sleep(5000);
        Assertions.assertEquals(DocumentLinksType.TERMS_CONDITIONS.getValue(),
                attachmentDocumentsOverlay.getAttachmentDocumentUrl(),
                String.format("Term Conditions link should be '%s'", DocumentLinksType.TERMS_CONDITIONS.getValue()));
        closeBrowser();
    }
}
