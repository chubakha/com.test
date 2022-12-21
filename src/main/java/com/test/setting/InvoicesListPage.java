package com.test.setting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InvoicesListPage {
    private final SelenideElement viewButton = $x("//button[contains(text(), 'View')]");
    private final SelenideElement statusInvoiceLabel = $x("//td[4]");

    public ChoicePaymentMethodPage clickViewButton(){
        viewButton.click();
        return new ChoicePaymentMethodPage();
    }

    public String getStatusInvoiceLabel(){
        return statusInvoiceLabel.getText();
    }

    public boolean isViewButtonShown(){
        return viewButton.isDisplayed();
    }
}
