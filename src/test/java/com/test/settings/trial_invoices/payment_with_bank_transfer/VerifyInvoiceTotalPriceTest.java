package com.test.settings.trial_invoices.payment_with_bank_transfer;

import com.test.login.LoginCabinetPage;
import com.test.setting.InvoiceDetailPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyInvoiceTotalPriceTest extends PrepareInvoicingTestData {

    @Test
    void verifyInvoiceTotalPrice(){

        InvoiceDetailPage invoiceDetailPage = new LoginCabinetPage()
                .setEmailField(invoicingClientEmail)
                .setPasswordField(invoicingClientPassword)
                .loginAsClient()
                .clickBillingLink()
                .clickViewButton()
                .clickBankTransferMethodPaymentMethodOption()
                .clickGoToPaymentButton()
                .clickCountryDropdown()
                .selectCountry("United Kingdom")
                .setCityField(faker.country().capital())
                .setZipField(faker.address().zipCode())
                .clickCurrencyDropdown()
                .selectCurrency(String.valueOf(InvoicesCurrencyType.values()[getRandomCurrency(5)]))
                .clickConfirmButtonWithRedirectionToInvoiceDetailPage();
        sleep(4000);
        Assertions.assertEquals("$" + trialInvoicePrice * 1.2, invoiceDetailPage.getTotalText(),
                String.format("'%s' should be shown next to total label",
                        "$" + trialInvoicePrice * 1.2));

    }
}
