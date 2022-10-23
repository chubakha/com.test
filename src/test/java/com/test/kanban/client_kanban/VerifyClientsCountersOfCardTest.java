package com.test.kanban.client_kanban;

import com.test.cabinet.client_cabinet_page.ClientKanbanPage;
import com.test.kanban.PrepareKanbanTestData;
import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyClientsCountersOfCardTest extends PrepareKanbanTestData {
    @Test
    void verifyClientsCountersOfCard(){
        ClientKanbanPage clientKanbanPage = new LoginCabinetPage()
                .setEmailField(clientEmailDataGeneration)
                .setPasswordField(clientPasswordDataGeneration)
                .loginAsClient();
        sleep(3000);
        Assertions.assertAll(
                () -> Assertions.assertEquals("2", clientKanbanPage.getAmountOfRequest(),
                        "Amount of requests should be equal to '2'"),
                () -> Assertions.assertEquals("3", clientKanbanPage.getAmountOfNewOffers(),
                        "Amount of new offers should be equal to '3'"),
                () -> Assertions.assertEquals("1", clientKanbanPage.getAmountOfTasksInProgress(),
                        "Amount of tasks in progress should be equal to '1'"),
                () -> Assertions.assertEquals("1", clientKanbanPage.getAmountOfTasksComplete(),
                        "Amount of tasks complete should be equal to '1'")
        );
    }
}
