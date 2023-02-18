package com.test.notifications.client_notify;

import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyRequestIsMovedToOfferNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyRequestIsMovedToOfferNotification(){
        MainNotificationsOverlay mainNotificationsOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstDraftCard()
                .clickPublishButton()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals("A new offer is awaiting your confirmation",
                mainNotificationsOverlay.getLastMessage(),
                "'A new offer is awaiting your confirmation.' should be shown as last notification");
    }

}
