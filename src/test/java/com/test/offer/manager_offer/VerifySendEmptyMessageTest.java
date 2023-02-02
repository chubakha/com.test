package com.test.offer.manager_offer;

import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifySendEmptyMessageTest extends PrepareOfferTestData {

    @Test
    void verifySendEmptyMessage(){

        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        ManagerDetailOfferPage lastMessage = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientCompany)
                .clickOfferCard(randomOfferOrRequest);
        ManagerDetailOfferPage currentLastMessage = new ManagerDetailOfferPage()
                .clickSendCommentButton();
        Assertions.assertEquals(lastMessage.getLastChatMessageText(), currentLastMessage.getLastChatMessageText(),
                String.format("'%s' should be as last message", lastMessage.getLastChatMessageText()));
    }
}
