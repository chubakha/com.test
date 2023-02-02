package com.test.setting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class BillingInfoOverlay {

    private final SelenideElement companyNameField = $x("//input[contains(@placeholder, 'Company Name')]");
    private final SelenideElement companyRegistrationNumberField = $x("//input[contains(@placeholder, 'Registration Number')]");
    private final SelenideElement countryDropdown = $x("//label[contains(text(), 'Country')]/following-sibling::div");
    private final SelenideElement selectedCountry = $x("//label[contains(text(), 'Country')]/..//div[contains(@class, 'react-select__single-value')]");
    private final SelenideElement cityField = $x("//input[contains(@placeholder, 'City')]");
    private final SelenideElement zipField = $x("//input[contains(@placeholder, 'ZIP')]");
    private final SelenideElement stateField = $x("//input[contains(@placeholder, 'State')]");
    private final SelenideElement billingAddressField = $x("//input[contains(@placeholder, 'Billing Address')]");
    private final SelenideElement currencyDropdown = $x("//label[contains(text(), 'Currency')]/following-sibling::div");
    private final SelenideElement vatNumberField = $x("//input[contains(@placeholder, 'VAT')]");
    private final SelenideElement confirmButton = $x("//button[contains(text(), 'Confirm')]");
    private final SelenideElement cancelButton = $x("//button[contains(text(), 'CANCEL')]");

    public BillingInfoOverlay clickCountryDropdown(){
        countryDropdown.click();
        return this;
    }

    public BillingInfoOverlay selectCountry(String country){
        $x("//div[contains(text(), '" + country +"')]").click();
        return this;
    }

    public BillingInfoOverlay clickCurrencyDropdown(){
        currencyDropdown.click();
        return this;
    }

    public BillingInfoOverlay selectCurrency(String currency){
        $x("//div[contains(text(), '" + currency +"')]").click();
        return this;
    }

    public BillingInfoOverlay setCityField(String city){
        cityField.val(city);
        return this;
    }

    public BillingInfoOverlay setZipField(String zip){
        zipField.val(zip);
        return this;
    }

    public BillingInfoOverlay setCompanyNameField(String companyName){
        companyNameField.val(companyName);
        return this;
    }

    public BillingInfoOverlay setCompanyRegistrationNumberField(String companyRegistrationNumber){
        companyRegistrationNumberField.val(companyRegistrationNumber);
        return this;
    }

    public BillingInfoOverlay setBillingAddressField(String billingAddress){
        billingAddressField.val(billingAddress);
        return this;
    }

    public BillingInfoOverlay setStateField(String state){
        stateField.val(state);
        return this;
    }

    public BillingInfoOverlay setVatNumberField(String vat){
        vatNumberField.val(vat);
        return this;
    }

    public BillingInfoOverlay clickConfirmButtonWithoutRedirection(){
        confirmButton.click();
        return this;
    }

    public StripePaymentPage clickConfirmButtonWithRedirectionToStripePage(){
        confirmButton.click();
        sleep(3000);
        return new StripePaymentPage();
    }

    public InvoiceDetailPage clickConfirmButtonWithRedirectionToInvoiceDetailPage(){
        confirmButton.click();
        sleep(5000);
        return new InvoiceDetailPage();
    }

    public String getCompanyRegistrationNumberField(){
        return companyRegistrationNumberField.val();
    }

    public String getBillingAddressField(){
        return billingAddressField.val();
    }

    public String getSelectedCountry(){
        return selectedCountry.getText();
    }

    public String getZipField(){
        return zipField.val();
    }

    public String getStateField(){
        return stateField.val();
    }

    public String getVatNumberField(){
        return vatNumberField.val();
    }


}
