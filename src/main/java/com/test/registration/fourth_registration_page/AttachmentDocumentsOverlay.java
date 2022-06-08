package com.test.registration.fourth_registration_page;

import static com.codeborne.selenide.Selenide.*;

public class AttachmentDocumentsOverlay {
    public String getAttachmentDocumentUrl(){
        switchTo().window(1);
        sleep(500);
        return webdriver().driver().getCurrentFrameUrl();
    }
}
