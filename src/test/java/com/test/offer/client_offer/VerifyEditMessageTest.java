package com.test.offer.client_offer;

import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyEditMessageTest extends PrepareOfferTestData {

    @Test
    void verifyEditMessage(){

        String oldClientMessage = faker.lorem().sentence();
        String newClientMessage = faker.lorem().sentence();
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        ClientDetailOfferPage clientDetailOfferPage = new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(oldClientMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton()
                .hoverEditMessageIcon()
                .clickEditMessageLink()
                .switchToChatIframe()
                .editCommentField(newClientMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton();
        Assertions.assertEquals(oldClientMessage + newClientMessage, clientDetailOfferPage.getLastChatMessageText(),  "Edit Message Popup should be shown");
    }
}
