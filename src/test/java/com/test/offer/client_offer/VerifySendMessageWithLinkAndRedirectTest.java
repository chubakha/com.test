package com.test.offer.client_offer;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifySendMessageWithLinkAndRedirectTest extends PrepareOfferTestData {

    @Test
    void verifySendMessageWithLinkAndRedirect(){

        String clientMessage = staticUrl;
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(clientMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton()
                .clickLastChatMessageText();
        switchTo().window(1);
        sleep(2000);
        Assertions.assertEquals(clientMessage, url(),
                        String.format("'%s' should be shown as current page url", "https://" + clientMessage));

    }

    @AfterAll
    static void closeWindows(){
        closeWindow();
    }
}
