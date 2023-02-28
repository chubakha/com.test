package com.test.notifications.vlo_notifications.email;

import com.test.GenericPage;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.kanban.client_kanban.ClientDetailRequestPage;
import com.test.login.LoginCabinetPage;
import com.test.mailers.MailHogNewCommentHasAddedInRequestChatNotificationPage;
import com.test.mailers.MailHogNewRequestHasCreatedMailNotificationPage;
import com.test.mailers.YopmailInboxMailPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyNewCommentHasAddedInRequestChatNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyNewCommentHasAddedInOfferChatNotification(){
        String clientMessage = faker.lorem().sentence();
        new LoginCabinetPage()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickFirstRequestCard()
                .switchToChatIframe()
                .setCommentField(clientMessage)
                .switchToRootContainerPage()
                .scrollToUpPage()
                .clickSendCommentButton();
        String titleRequest = new ClientDetailRequestPage()
                .getOfferTitle();
        String requestId = getEntityId();
        if (isProd) {
            YopmailInboxMailPage yopmailInboxMailPage = GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton()
                    .switchEmailIframe();
            Assertions.assertAll("New Comment Has Added In Chat should have next conditions:",
                    () -> Assertions.assertTrue(yopmailInboxMailPage.getMailContent().contains(String.format("A new comment has been added by \"%s\" to the following request: \"%s\". Click the link to view more.",
                            dataGenerationClientNotificationsFirstName + " " + dataGenerationClientNotificationsLastName, titleRequest)),
                            String.format("'A new comment has been added by \"%s\" to the following request: \"%s\". Click the link to view more.' should be shown",
                                    dataGenerationClientNotificationsFirstName + " " + dataGenerationClientNotificationsLastName, titleRequest)),
                    () -> Assertions.assertTrue(yopmailInboxMailPage.getMailContent().contains(String.format("/legal-request/%s",
                            requestId)),
                            String.format("'/offer/%s' should be shown in a email", requestId))
            );
        } else {
            MailHogNewCommentHasAddedInRequestChatNotificationPage
                    mailHogNewCommentHasAddedInRequestChatNotificationPage = GenericPage
                    .openMailHogPage()
                    .clickNewCommentHasAddedInRequestChatEmail(dataGenerationManagerEmail);
            sleep(2000);
           Assertions.assertAll("New Comment Has Added In Chat should have next conditions:",
                    () -> Assertions.assertTrue(mailHogNewCommentHasAddedInRequestChatNotificationPage
                                    .getMailContent().contains(String.format("A new comment has been added by \"%s\" to the following request: \"%s\". Click the link to view more.",
                                    dataGenerationClientNotificationsFirstName + " " + dataGenerationClientNotificationsLastName, titleRequest)),
                            String.format("'A new comment has been added by \"%s\" to the following request: \"%s\". Click the link to view more.' should be shown",
                                    dataGenerationClientNotificationsFirstName + " " + dataGenerationClientNotificationsLastName, titleRequest)),
                    () -> Assertions.assertTrue(mailHogNewCommentHasAddedInRequestChatNotificationPage
                                    .getMailContent().contains(String.format("/legal-request/%s",
                                    requestId)),
                            String.format("'/offer/%s' should be shown in a email", requestId))

            );
        }
    }

}
