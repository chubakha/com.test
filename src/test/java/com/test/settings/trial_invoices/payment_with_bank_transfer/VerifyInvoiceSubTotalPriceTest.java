package com.test.settings.trial_invoices.payment_with_bank_transfer;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.InvoiceDetailPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyInvoiceSubTotalPriceTest extends PrepareInvoicingTestData {

    @Test
    void verifyInvoiceSubTotalPrice(){

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
        Assertions.assertEquals("$" + trialInvoicePrice, invoiceDetailPage.getSubtotalText(),
                String.format("'%s' should be shown next to Subtotal label",
                        "$" + trialInvoicePrice));

    }
}
