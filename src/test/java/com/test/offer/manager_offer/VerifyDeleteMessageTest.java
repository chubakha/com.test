package com.test.offer.manager_offer;

import com.test.kanban.manager_kanban.EditMessageOverlay;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyDeleteMessageTest extends PrepareOfferTestData {

    @Test
    void verifyDeleteMessage(){

        String managerFirstMessage = faker.lorem().sentence();
        String clientLastMessage = faker.lorem().sentence();
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        ManagerDetailOfferPage managerDetailOfferPage = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerFirstMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton()
                .switchToChatIframe()
                .setCommentField(clientLastMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton()
                .hoverEditMessageIcon()
                .clickDeleteMessageLink();
        Assertions.assertEquals(managerFirstMessage, managerDetailOfferPage.getLastChatMessageText(),  "Edit Message Popup should be shown");
    }
}
