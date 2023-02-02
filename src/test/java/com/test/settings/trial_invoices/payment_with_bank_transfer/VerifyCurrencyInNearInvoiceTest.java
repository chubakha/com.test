package com.test.settings.trial_invoices.payment_with_bank_transfer;

import com.test.GenericPage;
import com.test.forgot_password_mail.MailHogInvoiceMailPage;
import com.test.forgot_password_mail.YopmailInboxMailPage;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyCurrencyInNearInvoiceTest extends PrepareInvoicingTestData {

    @Test
    void verifyCurrencyInNearInvoice(){

        boolean isProd = isProductionDomainShown(url());
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
                .selectCurrency(String.valueOf(InvoicesCurrencyType.USD.getValue()))
                .clickConfirmButtonWithRedirectionToInvoiceDetailPage()
                .clickIConfirmCheckbox()
                .clickGetInvoiceButton();
        localStorage().clear();
        if (isProd) {
            YopmailInboxMailPage yopmailInboxMailPage = GenericPage
                    .openYopmailPage()
                    .setLoginField(invoicingClientEmail)
                    .clickLoginButton()
                    .switchEmailIframe();
            Assertions.assertEquals("USD", yopmailInboxMailPage.getInvoiceCurrency(),
                    "'USD' should be shown in email letter");
        }
        else {
            MailHogInvoiceMailPage mailHogInvoiceMailPage = GenericPage
                    .openMailHogPage()
                    .clickInvoiceEmail(invoicingClientEmail);
            Assertions.assertEquals("USD", mailHogInvoiceMailPage.getInvoiceCurrency(),
                    "'USD' should be shown in email letter");
        }

    }
}
