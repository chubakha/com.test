package com.test.settings.trial_invoices.payment_with_bank_transfer;

import com.test.login.LoginCabinetPage;
import com.test.setting.InvoiceHasBeenSentPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAppearingInvoiceHasBeenSentPageTest extends PrepareInvoicingTestData {

    @Test
    void verifyAppearingInvoiceHasBeenSentPage(){
        InvoiceHasBeenSentPage invoiceHasBeenSentPage = new LoginCabinetPage()
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
                .clickIConfirmCheckbox()
                .clickGetInvoiceButton();
        sleep(1000);

        Assertions.assertAll(
                () -> Assertions.assertEquals("The Invoice has been sent to your email",
                        invoiceHasBeenSentPage.getTitlePage(),
                        "'The Invoice has been sent to your email' should be shown"),
                () -> Assertions.assertEquals("You will find all the necessary information for" +
                                " the payment inside the PDF attachment to the letter. Please visit your" +
                                " Email inbox to proceed with the payment.",
                        invoiceHasBeenSentPage.getSubtitlePage(),
                        "'You will find all the necessary information for the payment inside the" +
                                " PDF attachment to the letter. Please visit your Email inbox to proceed with the payment.'" +
                                " should be shown")
        );

    }
}
