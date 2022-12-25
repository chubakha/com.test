package com.test.setting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InvoiceHasBeenSentPage {

    private final SelenideElement titlePage = $x("//h1");
    private final SelenideElement subtitlePage = $x("//p[contains(@class, 'container_text')]");

    public String getTitlePage(){
        return titlePage.getText();
    }

    public String getSubtitlePage(){
        return subtitlePage.getText();
    }

}
