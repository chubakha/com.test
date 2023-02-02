package com.test.settings.trial_invoices;

import com.test.login.LoginCabinetPage;
import com.test.setting.ChoicePaymentMethodPage;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VerifyInvoiceDueDateTest extends PrepareInvoicingTestData {

    @Test
    void verifyInvoiceDueDate() {
        ChoicePaymentMethodPage choicePaymentMethodPage = new LoginCabinetPage()
                .setEmailField(invoicingClientEmail)
                .setPasswordField(invoicingClientPassword)
                .loginAsClient()
                .clickBillingLink()
                .clickViewButton();
        Date dueDateDate = new Date(new Date().getTime()+907300000);
        String dueDate = new SimpleDateFormat("dd/MM/yyyy").format(dueDateDate);
        Assertions.assertEquals(dueDate, choicePaymentMethodPage.getDueDateLabel(),
                String.format("'%s' date should be shown", dueDate)
                );
    }

}
