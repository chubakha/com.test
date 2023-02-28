package com.test.mailers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MailHogInvoiceMailPage {

    private final SelenideElement mailSubject = $x("//div[contains(@id, 'preview-plain')]");

    public String getInvoiceCurrency(){
        sleep(1000);
        int startCurrencyPosition = mailSubject.getOwnText().indexOf("for ") + 4;
        return mailSubject.getOwnText().substring(startCurrencyPosition,
                startCurrencyPosition + 3);
    }

}
