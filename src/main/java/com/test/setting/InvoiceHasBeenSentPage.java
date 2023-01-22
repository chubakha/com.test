package com.test.setting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class InvoiceHasBeenSentPage {

    private final SelenideElement titlePage = $x("//h1");
    private final SelenideElement subtitlePage = $x("//p[contains(@class, 'container_text')]");

    public String getTitlePage(){
        sleep(2000);
        return titlePage.getText();
    }

    public String getSubtitlePage(){
        return subtitlePage.getText();
    }

}
