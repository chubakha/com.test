package com.test.settings.trial_invoices;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.ChoicePaymentMethodPage;
import com.test.settings.PrepareInvoicingTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyInvoiceDueDateTest extends PrepareInvoicingTestData {

    @Test
    void verifyInvoiceDueDate() {
        ChoicePaymentMethodPage choicePaymentMethodPage = new ClientKanbanPage()
                .clickBillingLink()
                .clickViewButton();
        Date dueDateDate = new Date(new Date().getTime()+1814400000);
        String dueDate = new SimpleDateFormat("dd/MM/yyyy").format(dueDateDate);
        sleep(1000);
        Assertions.assertEquals(dueDate, choicePaymentMethodPage.getDueDateLabel(),
                String.format("'%s' date should be shown", getTodayDateEuSlash())
                );
    }

}
