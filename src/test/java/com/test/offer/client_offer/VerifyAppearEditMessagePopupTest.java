package com.test.offer.client_offer;

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

        EditMessageOverlay editMessageOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(clientMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton()
                .hoverEditMessageIcon();
        Assertions.assertTrue(editMessageOverlay.isEditMessagePopupShown(),
                "Edit Message Popup should be shown");
    }
}
