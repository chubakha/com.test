package com.test.offer.client_offer;

import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifySendMaxLimitSymbolsMessageTest extends PrepareOfferTestData {

    @Test
    void verifySendMaxLimitSymbolMessage(){

        String clientMessage = faker.lorem().fixedString(limitChatMessage);
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        ClientDetailOfferPage clientDetailOfferPage = new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(clientMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton();
        Assertions.assertEquals(clientMessage, clientDetailOfferPage.getLastChatMessageText(),
                        String.format("'%s' message should be shown as last", clientMessage));

    }
}
