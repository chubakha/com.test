package com.test.registration.fourth_registration_page;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;

public class AttachmentDocumentsOverlay {
    public String getAttachmentDocumentUrl(){
        switchTo().window(1);
        return webdriver().driver().getCurrentFrameUrl();
    }
}
