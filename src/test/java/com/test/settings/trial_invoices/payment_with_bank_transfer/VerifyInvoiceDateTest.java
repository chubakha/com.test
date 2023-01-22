package com.test.settings.trial_invoices.payment_with_bank_transfer;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.InvoiceDetailPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyInvoiceDateTest extends PrepareInvoicingTestData {

    @Test
    void verifyInvoiceDate(){

        InvoiceDetailPage invoiceDetailPage = new ClientKanbanPage()
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
        sleep(1000);
        Assertions.assertEquals(getTodayDateEuSlash(), invoiceDetailPage.getDateText(),
                String.format("'%s' should be shown next to date label",
                        getTodayDateEuSlash()));

    }
}
