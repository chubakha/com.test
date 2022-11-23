package com.test.invoices;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InvoicePage {

    private final SelenideElement priceText = $x("//div[contains(@class, 'total-value')]");

    public String getPriceInvoice(){
        return priceText.getText();
    }

}
