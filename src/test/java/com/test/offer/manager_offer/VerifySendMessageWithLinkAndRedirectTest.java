package com.test.offer.manager_offer;

import com.test.PrepareOverallTestData;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
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

        String managerMessage = staticUrl;
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        ManagerDetailOfferPage managerDetailOfferPage = new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton()
                .clickLastChatMessageText();
        switchTo().window(1);
        sleep(2000);
        Assertions.assertEquals(managerMessage, url(),
                        String.format("'%s' should be shown as current page url", managerMessage));
    }

    @AfterAll
    static void closeWindows(){
        closeWindow();
    }
}
