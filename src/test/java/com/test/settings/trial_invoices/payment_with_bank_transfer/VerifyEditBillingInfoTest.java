package com.test.settings.trial_invoices.payment_with_bank_transfer;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.BillingInfoOverlay;
import com.test.setting.InvoiceDetailPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyEditBillingInfoTest extends PrepareInvoicingTestData {

    @Test
    void verifyEditBillingInfo(){

        new LoginCabinetPage()
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
                .clickConfirmButtonWithRedirectionToInvoiceDetailPage()
                .clickEditInvoiceButton();

        String newCompanyNumber = faker.phoneNumber().cellPhone();
        String newBillingAddress = faker.address().fullAddress();
        String newCountry = "Germany";
        String newZip = faker.address().zipCode();
        String newState = faker.address().state();
        String newVatNumber = faker.lorem().characters(1, 16);

        InvoiceDetailPage invoiceDetailPage = new BillingInfoOverlay()
                .setCompanyRegistrationNumberField(newCompanyNumber)
                .setBillingAddressField(newBillingAddress)
                .clickCountryDropdown()
                .selectCountry(newCountry)
                .setZipField(newZip)
                .setStateField(newState)
                .setVatNumberField(newVatNumber)
                .clickConfirmButtonWithRedirectionToInvoiceDetailPage();
        Assertions.assertAll(
                () -> Assertions.assertEquals(newCompanyNumber,
                        invoiceDetailPage.getCompanyNumberText(),
                        String.format("'%s' should be shown", newCompanyNumber)),
                () -> Assertions.assertEquals(newBillingAddress,
                        invoiceDetailPage.getBillingAddressText(),
                        String.format("'%s' should be shown", newBillingAddress)),
                () -> Assertions.assertEquals(newCountry,
                        invoiceDetailPage.getCountryText(),
                        String.format("'%s' should be shown", newCountry)),
                () -> Assertions.assertEquals(newZip,
                        invoiceDetailPage.getZipText(),
                        String.format("'%s' should be shown", newZip)),
                () -> Assertions.assertEquals(newState,
                        invoiceDetailPage.getStateText(),
                        String.format("'%s' should be shown", newState)),
                () -> Assertions.assertEquals(newVatNumber,
                        invoiceDetailPage.getVatNumberText(),
                        String.format("'%s' should be shown", newVatNumber))
        );

    }
}
