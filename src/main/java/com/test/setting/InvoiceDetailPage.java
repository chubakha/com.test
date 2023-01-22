package com.test.setting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class InvoiceDetailPage {

    private final SelenideElement editInvoiceButton = $x("//button[contains(@class, 'invoice-edit')]");
    private final SelenideElement companyNumberText = $x("//*[contains(text(), 'Company number')]/following-sibling::span");
    private final SelenideElement billingAddressText = $x("//*[contains(text(), 'Billing Address')]/following-sibling::span");
    private final SelenideElement countryText = $x("//*[contains(text(), 'Country')]/following-sibling::span");
    private final SelenideElement zipText = $x("//*[contains(text(), 'Zip')]/following-sibling::span");
    private final SelenideElement stateText = $x("//*[contains(text(), 'State')]/following-sibling::span");
    private final SelenideElement vatNumberText = $x("//*[contains(text(), 'Vat Number')]/following-sibling::span");
    private final SelenideElement iConfirmCheckbox = $x("//span[contains(@class, 'checkbox_label')]");
    private final SelenideElement getInvoiceButton = $x("//button[contains(text(), 'GET INVOICE')]");
    private final SelenideElement createdDateInvoiceText = $x("//button[contains(text(), 'GET INVOICE')]");
    private final SelenideElement dateText = $x("//*[contains(text(), 'Date')]/following-sibling::div");
    private final SelenideElement descriptionText = $x("//*[contains(text(), 'Description')]/following-sibling::div");
    private final SelenideElement subtotalText = $x("//*[contains(text(), 'Subtotal')]/following-sibling::span");
    private final SelenideElement vatValueText = $x("//*[contains(text(), 'VAT')]/following-sibling::span");
    private final SelenideElement totalText = $x("//*[contains(text(), 'Total')]/following-sibling::span");

    public String getCompanyNumberText(){
        return companyNumberText.getText();
    }

    public String getBillingAddressText(){
        return billingAddressText.getText();
    }

    public String getCountryText(){
        return countryText.getText();
    }

    public String getZipText(){
        return zipText.getText();
    }

    public String getStateText(){
        return stateText.getText();
    }

    public String getVatNumberText(){
        return vatNumberText.getText();
    }

    public InvoiceDetailPage clickIConfirmCheckbox(){
        iConfirmCheckbox.click();
        return this;
    }

    public InvoiceHasBeenSentPage clickGetInvoiceButton(){
        getInvoiceButton.click();
        sleep(3000);
        return new InvoiceHasBeenSentPage();
    }

    public BillingInfoOverlay clickEditInvoiceButton(){
        editInvoiceButton.click();
        return new BillingInfoOverlay();
    }

    public String getCreatedDateInvoiceText(){
        return createdDateInvoiceText.getText();
    }

    public String getDateText(){
        return dateText.getText();
    }

    public String getDescriptionText(){
        return descriptionText.getText();
    }

    public String getSubtotalText(){
        return subtotalText.getText();
    }

    public String getVatValueText(){
        return vatValueText.getText();
    }

    public String getTotalText(){
        return totalText.getText();
    }
}
