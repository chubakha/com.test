package com.test.notifications.vlo_notifications.email;

import com.test.GenericPage;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.login.LoginCabinetPage;
import com.test.mailers.MailHogNewCommentHasAddedInOfferChatNotificationPage;
import com.test.mailers.YopmailInboxMailPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyNewCommentHasAddedInOfferChatNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyNewCommentHasAddedInOfferChatNotification(){
        String randomOffer = String.valueOf((int) (Math.ceil(Math.random()*6)));
        String clientMessage = faker.lorem().sentence();
        new LoginCabinetPage()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickOfferCard(randomOffer)
                .switchToChatIframe()
                .setCommentField(clientMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton();
        String titleOffer = new ClientDetailOfferPage()
                .getOfferTitle();
        String offerId = getEntityId();
        if (isProd) {
            YopmailInboxMailPage yopmailInboxMailPage = GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton()
                    .switchEmailIframe();
            Assertions.assertAll("New Comment Has Added In Chat should have next conditions:",
                    () -> Assertions.assertTrue(yopmailInboxMailPage.getMailContent().contains(String.format("A new comment has been added by \"%s\" to the following offer: \"%s\". Click the link to view more.",
                            dataGenerationClientNotificationsFirstName + " " + dataGenerationClientNotificationsLastName, titleOffer)),
                            String.format("'A new comment has been added by \"%s\" to the following offer: \"%s\". Click the link to view more.' should be shown",
                                    dataGenerationClientNotificationsFirstName + " " + dataGenerationClientNotificationsLastName, titleOffer)),
                    () -> Assertions.assertTrue(yopmailInboxMailPage.getMailContent().contains(String.format("/offer/%s",
                            offerId)),
                            String.format("'/offer/%s' should be shown in a email", offerId))
            );
        } else {
            MailHogNewCommentHasAddedInOfferChatNotificationPage
                    mailHogNewCommentHasAddedInOfferChatNotificationPage = GenericPage
                    .openMailHogPage()
                    .clickNewCommentHasAddedInOfferChatEmail(dataGenerationManagerEmail);
            sleep(2000);
           Assertions.assertAll("New Comment Has Added In Chat should have next conditions:",
                    () -> Assertions.assertTrue(mailHogNewCommentHasAddedInOfferChatNotificationPage
                                    .getMailContent().contains(String.format("A new comment has been added by \"%s\" to the following offer: \"%s\". Click the link to view more.",
                                    dataGenerationClientNotificationsFirstName + " " + dataGenerationClientNotificationsLastName, titleOffer)),
                            String.format("'A new comment has been added by \"%s\" to the following offer: \"%s\". Click the link to view more.' should be shown",
                                    dataGenerationClientNotificationsFirstName + " " + dataGenerationClientNotificationsLastName, titleOffer)),
                    () -> Assertions.assertTrue(mailHogNewCommentHasAddedInOfferChatNotificationPage
                                    .getMailContent().contains(String.format("/offer/%s",
                                    offerId)),
                            String.format("'/offer/%s' should be shown in a email", offerId))

            );
        }
    }

}
