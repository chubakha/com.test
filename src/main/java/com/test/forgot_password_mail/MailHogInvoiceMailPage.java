package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MailHogInvoiceMailPage {

    private final SelenideElement mailSubject = $x("//div[contains(@id, 'preview-plain')]");

    public String getInvoiceCurrency(){
        int startCurrencyPosition = mailSubject.getOwnText().indexOf("for ") + 4;
        return mailSubject.getOwnText().substring(startCurrencyPosition,
                startCurrencyPosition + 3);
    }

}
