package com.test.offer.manager_offer;

import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyEditMessageTest extends PrepareOfferTestData {

    @Test
    void verifyEditMessage(){

        String oldManagerMessage = faker.lorem().sentence();
        String newManagerMessage = faker.lorem().sentence();
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(2000);
        new ManagerKanbanPage()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(oldManagerMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton();
        sleep(1000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerDetailOfferPage()
                .hoverEditMessageIcon()
                .clickEditMessageLink()
                .switchToChatIframe()
                .editCommentField(newManagerMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton();
        sleep(1000);
        Assertions.assertEquals(oldManagerMessage + newManagerMessage, managerDetailOfferPage.getLastChatMessageText(),  "Edit Message Popup should be shown");
    }
}
