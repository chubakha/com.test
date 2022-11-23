package com.test.offer.client_offer;

import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifySendEmptyMessageTest extends PrepareOfferTestData {

    @Test
    void verifySendEmptyMessage(){

        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        ClientDetailOfferPage lastMessage = new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickOfferCard(randomOfferOrRequest);
        sleep(3000);
        ClientDetailOfferPage currentLastMessage = new ClientDetailOfferPage()
                .clickSendCommentButton();
        sleep(3000);
        Assertions.assertEquals(lastMessage.getLastChatMessageText(), currentLastMessage.getLastChatMessageText(),
                String.format("'%s' should be as last message", lastMessage.getLastChatMessageText()));
    }
}
