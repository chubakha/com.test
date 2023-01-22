package com.test.setting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class InvoicesListPage {
    private final SelenideElement viewButton = $x("//button[contains(text(), 'View')]");
    private final SelenideElement statusInvoiceLabel = $x("//td[4]");

    public ChoicePaymentMethodPage clickViewButton(){
        sleep(1000);
        viewButton.click();
        return new ChoicePaymentMethodPage();
    }

    public String getStatusInvoiceLabel(){
        sleep(15000);
        return statusInvoiceLabel.getText();
    }

    public boolean isViewButtonShown(){
        return viewButton.isDisplayed();
    }
}
