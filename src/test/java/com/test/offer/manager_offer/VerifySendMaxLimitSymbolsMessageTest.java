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

        ManagerDetailOfferPage managerDetailOfferPage = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientCompany)
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton();
        Assertions.assertEquals(managerMessage, managerDetailOfferPage.getLastChatMessageText(),
                        String.format("'%s' message should be shown as last", managerMessage));
    }
}
