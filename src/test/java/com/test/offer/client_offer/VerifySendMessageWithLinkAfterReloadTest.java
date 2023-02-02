package com.test.offer.client_offer;

import com.test.PrepareOverallTestData;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifySendMessageWithLinkAfterReloadTest extends PrepareOfferTestData {

    @Test
    void verifySendMessageWithLinkAfterReload(){

        String clientMessage = staticUrl;
        String todayDate = (new PrepareOverallTestData().getTodayDateEuSlash());
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        ClientDetailOfferPage clientDetailOfferPage = new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(clientMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton();
        refreshPage();
        Assertions.assertAll(
                () -> Assertions.assertEquals(clientMessage, clientDetailOfferPage.getLastChatMessageText(),
                        String.format("'%s' message should be shown as last", clientMessage)),
                () -> Assertions.assertEquals(dataGenerationClientFirstName + " " + dataGenerationClientLastName,
                        clientDetailOfferPage.getLastChatMessageAuthor(),
                        "'DataGenerationFirstName DataGenerationLastName' should be shown as author of last message"),
                () -> Assertions.assertEquals(todayDate, clientDetailOfferPage.getLastChatMessageDate(),
                        String.format("'%s' should be shown as date of last message", todayDate))
        );

    }
}
