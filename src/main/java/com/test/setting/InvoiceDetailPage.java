package com.test.setting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InvoiceDetailPage {

    private final SelenideElement viewButton = $x("//button[contains(text(), 'View')]");
}
