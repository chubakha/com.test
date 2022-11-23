package com.test.offer.client_offer;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.kanban.client_kanban.EditMessageOverlay;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAppearEditMessagePopupTest extends PrepareOfferTestData {

    @Test
    void verifyAppearEditMessagePopup(){

        String clientMessage = faker.lorem().sentence();
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient();
        sleep(2000);
        EditMessageOverlay editMessageOverlay = new ClientKanbanPage()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(clientMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton()
                .hoverEditMessageIcon();
        sleep(2000);
        Assertions.assertTrue(editMessageOverlay.isEditMessagePopupShown(), "Edit Message Popup should be shown");
    }
}
