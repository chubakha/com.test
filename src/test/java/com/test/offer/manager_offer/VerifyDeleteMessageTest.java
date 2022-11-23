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

        String managerMessage = faker.lorem().sentence();
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(2000);
        new ManagerKanbanPage()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton()
                .hoverEditMessageIcon();
        sleep(1000);
        ManagerDetailOfferPage managerDetailOfferPage = new EditMessageOverlay()
                .clickDeleteMessageLink();
        sleep(1000);
        Assertions.assertNotEquals(managerMessage, managerDetailOfferPage.getLastChatMessageText(),  "Edit Message Popup should be shown");
    }
}
