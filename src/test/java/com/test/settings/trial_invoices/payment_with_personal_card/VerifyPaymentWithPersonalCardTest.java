package com.test.settings.trial_invoices.payment_with_personal_card;

import com.test.GenericPage;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.InvoicesCurrencyType;
import com.test.setting.InvoicesListPage;
import com.test.setting.InvoicesStatusesType;
import com.test.setting.StripePaymentPage;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VerifyPaymentWithPersonalCardTest extends PrepareInvoicingTestData {

    @BeforeAll
    static void login(){
        GenericPage.openLoginPage();
        new LoginCabinetPage()
                .setEmailField(invoicingClientEmail)
                .setPasswordField(invoicingClientPassword)
                .loginAsClient();
    }

    //@ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "111", "222", "333", "444", "555", "666", "777", "888", "999", "101",
            "102", "103", "104", "105", "106", "107", "108", "109", "110", "112" })
    void verifyPaymentWithPersonalCard(String value){

        InvoicesListPage invoicesListPage = new ClientKanbanPage()
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
                .clickConfirmButtonWithRedirectionToStripePage()
                .setCreditCardNumberField(testCreditCardNumber)
                .setCardExpiryField(testCardExpiry)
                .setCardCvcField(value)
                .setCardHolderField(testCardHolder)
                .clickPayButton();
        Assertions.assertAll(
                () -> Assertions.assertEquals(InvoicesStatusesType.CLOSED.getValue(), invoicesListPage.getStatusInvoiceLabel(),
                        String.format("'%s' should be as invoice status", InvoicesStatusesType.CLOSED.getValue())),
                () -> Assertions.assertFalse(invoicesListPage.isViewButtonShown(),
                        "'View' button should not be shown in invoice")
        );

    }

    @AfterEach
    void changeTrialInvoiceToUnpaidTest(){
        changeTrialInvoiceToUnpaid();
    }
}
