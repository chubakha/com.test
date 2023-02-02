package com.test.offer.manager_offer;

import com.test.kanban.manager_kanban.EditMessageOverlay;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAppearEditMessagePopupTest extends PrepareOfferTestData {

    @Test
    void verifyAppearEditMessagePopup(){

        String managerMessage = faker.lorem().sentence();
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        EditMessageOverlay editMessageOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton()
                .hoverEditMessageIcon();
        Assertions.assertTrue(editMessageOverlay.isEditMessagePopupShown(), "Edit Message Popup should be shown");
    }
}
