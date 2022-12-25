package com.test.settings.trial_invoices;

import com.test.login.LoginCabinetPage;
import com.test.setting.ChoicePaymentMethodPage;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyInvoiceCreationDateTest extends PrepareInvoicingTestData {

    @Test
    void verifyInvoiceCreationDate(){
        ChoicePaymentMethodPage choicePaymentMethodPage = new LoginCabinetPage()
                .setEmailField(invoicingClientEmail)
                .setPasswordField(invoicingClientPassword)
                .loginAsClient()
                .clickBillingLink()
                .clickViewButton();
        sleep(1000);
        Assertions.assertEquals(getTodayDateEuSlash(), choicePaymentMethodPage.getCreatedDateLabel(),
                String.format("'%s' date should be shown", getTodayDateEuSlash())
                );
    }

}
