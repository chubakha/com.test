package com.test.notifications.vlo_notify;

import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyRequestHasCreatedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyRequestIsCreatedNotification(){
        MainNotificationsOverlay mainNotificationsOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNewRequestButton()
                .clickCreateNewRequestButton()
                .setTitleField(faker.lorem().sentence())
                .switchToDescriptionIframe()
                .setDescriptionField(faker.lorem().sentence())
                .switchFocusToOverlay()
                .clickSubmitButton()
                .clickLogOutLink()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickNotificationsIcon();
        Assertions.assertEquals("A new request has been created by the client",
                mainNotificationsOverlay.getLastMessage(),
                "'A new request has been created by the client' should be shown as last notification");
    }

}
