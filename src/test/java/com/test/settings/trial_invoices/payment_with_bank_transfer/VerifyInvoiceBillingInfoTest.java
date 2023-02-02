package com.test.settings.trial_invoices.payment_with_bank_transfer;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.BillingInfoOverlay;
import com.test.setting.InvoiceDetailPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyInvoiceBillingInfoTest extends PrepareInvoicingTestData {

    @Test
    void verifyBillingInfo(){
        BillingInfoOverlay billingInfoOverlay = new LoginCabinetPage()
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
                .selectCurrency(String.valueOf(InvoicesCurrencyType.values()[getRandomCurrency(5)]));

        String companyNumber = billingInfoOverlay.getCompanyRegistrationNumberField();
        String billingAddress = billingInfoOverlay.getBillingAddressField();
        String country = billingInfoOverlay.getSelectedCountry();
        String zip = billingInfoOverlay.getZipField();
        String state = billingInfoOverlay.getStateField();
        String vat = billingInfoOverlay.getVatNumberField();

        InvoiceDetailPage invoiceDetailPage = new BillingInfoOverlay()
                .clickConfirmButtonWithRedirectionToInvoiceDetailPage();
        Assertions.assertAll(
                () -> Assertions.assertEquals(companyNumber,
                        invoiceDetailPage.getCompanyNumberText(),
                        String.format("'%s' should be shown", companyNumber)),
                () -> Assertions.assertEquals(billingAddress,
                        invoiceDetailPage.getBillingAddressText(),
                        String.format("'%s' should be shown", billingAddress)),
                () -> Assertions.assertEquals(country,
                        invoiceDetailPage.getCountryText(),
                        String.format("'%s' should be shown", country)),
                () -> Assertions.assertEquals(zip,
                        invoiceDetailPage.getZipText(),
                        String.format("'%s' should be shown", zip)),
                () -> Assertions.assertEquals(state,
                        invoiceDetailPage.getStateText(),
                        String.format("'%s' should be shown", state)),
                () -> Assertions.assertEquals(vat,
                        invoiceDetailPage.getVatNumberText(),
                        String.format("'%s' should be shown", vat))
        );

    }
}
