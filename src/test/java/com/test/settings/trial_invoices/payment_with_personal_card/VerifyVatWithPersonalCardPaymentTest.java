package com.test.settings.trial_invoices.payment_with_personal_card;

import com.test.login.LoginCabinetPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.setting.InvoicesListPage;
import com.test.setting.InvoicesStatusesType;
import com.test.setting.StripePaymentPage;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyVatWithPersonalCardPaymentTest extends PrepareInvoicingTestData {

    @Test
    void verifyPaymentWithPersonalCard(){
        new LoginCabinetPage()
                .setEmailField(invoicingClientEmail)
                .setPasswordField(invoicingClientPassword)
                .loginAsClient()
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
                .clickConfirmButtonWithRedirection();
        sleep(2000);
        InvoicesListPage invoicesListPage = new StripePaymentPage()
                .setCreditCardNumberField(testCreditCardNumber)
                .setCardExpiryField(testCardExpiry)
                .setCardCvcField(testCardCvc)
                .setCardHolderField(testCardHolder)
                .clickPayButton();
        sleep(8000);
        Assertions.assertAll(
                () -> Assertions.assertEquals(InvoicesStatusesType.CLOSED.getValue(), invoicesListPage.getStatusInvoiceLabel(),
                        String.format("'%s' should be as invoice status", InvoicesStatusesType.CLOSED.getValue())),
                () -> Assertions.assertFalse(invoicesListPage.isViewButtonShown(),
                        "'View' button should not be shown in invoice")
        );

    }

    @AfterAll
    static void changeTrialInvoiceToUnpaidTest(){
        changeTrialInvoiceToUnpaid();
    }
}
