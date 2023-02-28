package com.test.notifications.vlo_notifications.email;

import com.test.GenericPage;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.login.LoginCabinetPage;
import com.test.mailers.MailHogStatusHasChangedToAcceptedNotificationPage;
import com.test.mailers.YopmailInboxMailPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyOfferStatusHasChangedToAcceptedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyOfferStatusHasChangedToAcceptedNotification(){
        new LoginCabinetPage()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickFirstPleaseAcceptOfferCard()
                .clickAcceptButton();
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
                    () -> Assertions.assertTrue(yopmailInboxMailPage
                                    .getMailContent().contains(String.format("Great news, the offer \"%s\" has been accepted by the client. Click the link to view more.",
                            titleOffer)),
                            String.format("'Great news, the offer \"%s\" has been accepted by the client. Click the link to view more.' should be shown",
                                    titleOffer)),
                    () -> Assertions.assertTrue(yopmailInboxMailPage.getMailContent().contains(String.format("/offer/%s",
                            offerId)),
                            String.format("'/offer/%s' should be shown in a email", offerId))
            );
        } else {
            MailHogStatusHasChangedToAcceptedNotificationPage
                    mailHogStatusHasChangedToAcceptedNotificationPage = GenericPage
                    .openMailHogPage()
                    .clickStatusIsChangedToAcceptedEmail(dataGenerationManagerEmail);
            sleep(2000);
           Assertions.assertAll("Offer Status Is Changed To Accepted",
                    () -> Assertions.assertTrue(mailHogStatusHasChangedToAcceptedNotificationPage
                                    .getMailContent().contains(String.format("Great news, the offer \"%s\" has been accepted by the client. Click the link to view more.",
                                    titleOffer)),
                            String.format("'Great news, the offer \"%s\" has been accepted by the client. Click the link to view more.",
                                    titleOffer)),
                    () -> Assertions.assertTrue(mailHogStatusHasChangedToAcceptedNotificationPage
                                    .getMailContent().contains(String.format("/offer/%s",
                                    offerId)),
                            String.format("'/offer/%s' should be shown in a email", offerId))

            );
        }
    }

}
