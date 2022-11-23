package com.test.offer.client_offer;

import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.kanban.client_kanban.EditMessageOverlay;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyDeleteMessageTest extends PrepareOfferTestData {

    @Test
    void verifyDeleteMessage(){

        String clientMessage = faker.lorem().sentence();
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient();
        sleep(2000);
        new ClientKanbanPage()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(clientMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton()
                .hoverEditMessageIcon();
        sleep(1000);
        ClientDetailOfferPage clientDetailOfferPage = new EditMessageOverlay()
                .clickDeleteMessageLink();
        sleep(1000);
        Assertions.assertNotEquals(clientMessage, clientDetailOfferPage.getLastChatMessageText(),  "Edit Message Popup should be shown");
    }
}
