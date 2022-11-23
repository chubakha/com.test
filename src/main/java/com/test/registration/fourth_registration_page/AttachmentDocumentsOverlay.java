package com.test.registration.fourth_registration_page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AttachmentDocumentsOverlay {
    public String getAttachmentDocumentUrl(){
        switchTo().window(1);
        return webdriver().driver().getCurrentFrameUrl();
    }
}
