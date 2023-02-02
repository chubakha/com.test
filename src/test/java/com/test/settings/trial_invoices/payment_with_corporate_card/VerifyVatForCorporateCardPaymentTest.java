package com.test.settings.trial_invoices.payment_with_corporate_card;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.setting.StripePaymentPage;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyVatForCorporateCardPaymentTest extends PrepareInvoicingTestData {

    @Test
    void verifyVatForCorporateCardPayment(){

        StripePaymentPage stripePaymentPage = new LoginCabinetPage()
                .setEmailField(invoicingClientEmail)
                .setPasswordField(invoicingClientPassword)
                .loginAsClient()
                .clickBillingLink()
                .clickViewButton()
                .clickCorporateCardPaymentMethodOption()
                .clickGoToPaymentButton()
                .clickCountryDropdown()
                .selectCountry("United Kingdom")
                .setCityField(faker.country().capital())
                .setZipField(faker.address().zipCode())
                .clickCurrencyDropdown()
                .selectCurrency(String.valueOf(InvoicesCurrencyType.values()[getRandomCurrency(5)]))
                .clickConfirmButtonWithRedirectionToStripePage()
                .clickCountryDropdown()
                .clickGBCountry();
        Assertions.assertEquals("VAT (20 %)", stripePaymentPage.getVatValue(),
                        "'VAT (20 %)' should be shown as VAT value");

    }
}
