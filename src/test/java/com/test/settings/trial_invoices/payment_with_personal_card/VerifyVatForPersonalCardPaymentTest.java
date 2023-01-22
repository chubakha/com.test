package com.test.settings.trial_invoices.payment_with_personal_card;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.setting.StripePaymentPage;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyVatForPersonalCardPaymentTest extends PrepareInvoicingTestData {

    @Test
    void verifyVatForPersonalCardPayment(){
        StripePaymentPage stripePaymentPage = new ClientKanbanPage()
                .clickBillingLink()
                .clickViewButton()
                .clickPersonalCardPaymentMethodOption()
                .clickGoToPaymentButton()
                .clickCountryDropdown()
                .selectCountry("United Kingdom")
                .setCityField(faker.country().capital())
                .setZipField(faker.address().zipCode())
                .clickCurrencyDropdown()
                .selectCurrency(String.valueOf(InvoicesCurrencyType.values()[getRandomCurrency(5)]))
                .clickConfirmButtonWithRedirectionToStripePage();
        Assertions.assertEquals("Sales tax (20 %)", stripePaymentPage.getVatValue(),
                        "'Sales tax (20 %)' should be shown as VAT for trial payment");

    }
}
