package com.test.notifications.vlo_notifications.email;

import com.test.GenericPage;
import com.test.mailers.MailHogNewRequestHasCreatedMailNotificationPage;
import com.test.mailers.YopmailInboxMailPage;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyRequestHasCreatedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyRequestHasCreatedNotification(){
        new LoginCabinetPage()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNewRequestButton()
                .clickCreateNewRequestButton()
                .setTitleField(faker.lorem().sentence())
                .switchToDescriptionIframe()
                .setDescriptionField(faker.lorem().sentence())
                .switchFocusToOverlay()
                .clickSubmitButton();
        String requestId = getEntityId();
        if (isProd) {
            YopmailInboxMailPage yopmailInboxMailPage = GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton()
                    .switchEmailIframe();
            Assertions.assertAll("Request Has Created letter should have next conditions:",
                    () -> Assertions.assertTrue(yopmailInboxMailPage.getMailContent().contains(String.format("A new request has been created by \"%s\". Click the link to view more.",
                            dataGenerationClientNotificationsCompany)),
                            String.format("'A new request has been created by \"%s\". Click the link to view more.' should be shown",
                                    dataGenerationClientNotificationsCompany)),
                    () -> Assertions.assertTrue(yopmailInboxMailPage.getMailContent().contains(String.format("/legal-request/%s",
                            requestId)),
                            String.format("'/legal-request/%s' should be shown in a email", requestId))
            );
        } else {
            MailHogNewRequestHasCreatedMailNotificationPage
                    mailHogNewRequestHasCreatedMailNotificationPage = GenericPage
                    .openMailHogPage()
                    .clickNewRequestHasCreatedEmail(dataGenerationManagerEmail);
            sleep(2000);
            Assertions.assertAll("Request Has Created letter should have next conditions:",
                    () -> Assertions.assertTrue(mailHogNewRequestHasCreatedMailNotificationPage
                                    .getMailContent().contains(String.format("A new request has been created by \"%s\". Click the link to view more.",
                                    dataGenerationClientNotificationsCompany)),
                            String.format("'A new request has been created by \"%s\". Click the link to view more.' should be shown",
                                    dataGenerationClientNotificationsCompany)),
                    () -> Assertions.assertTrue(mailHogNewRequestHasCreatedMailNotificationPage
                                    .getMailContent().contains(String.format("/legal-request/%s",
                                    requestId)),
                            String.format("'/legal-request/%s' should be shown in a email", requestId))

            );
        }
    }

}
