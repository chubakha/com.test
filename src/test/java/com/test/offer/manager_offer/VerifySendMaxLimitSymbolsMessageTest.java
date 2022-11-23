package com.test.offer.manager_offer;

import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifySendMaxLimitSymbolsMessageTest extends PrepareOfferTestData {

    @Test
    void verifySendMaxLimitSymbolsMessage(){

        String managerMessage = faker.lorem().fixedString(limitChatMessage);
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientCompany);
        sleep(2000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton();
        sleep(3000);
        Assertions.assertEquals(managerMessage, managerDetailOfferPage.getLastChatMessageText(),
                        String.format("'%s' message should be shown as last", managerMessage));
    }
}
