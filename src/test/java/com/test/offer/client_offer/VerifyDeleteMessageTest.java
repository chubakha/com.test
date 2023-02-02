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

        String clientFirstMessage = faker.lorem().sentence();
        String clientLastMessage = faker.lorem().sentence();
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        ClientDetailOfferPage clientDetailOfferPage = new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(clientFirstMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton()
                .switchToChatIframe()
                .setCommentField(clientLastMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton()
                .hoverEditMessageIcon()
                .clickDeleteMessageLink();
        Assertions.assertEquals(clientFirstMessage, clientDetailOfferPage.getLastChatMessageText(),  "Edit Message Popup should be shown");
    }
}
