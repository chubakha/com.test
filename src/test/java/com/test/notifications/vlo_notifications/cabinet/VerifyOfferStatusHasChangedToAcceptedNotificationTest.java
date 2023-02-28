package com.test.notifications.vlo_notifications.cabinet;

import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyOfferStatusHasChangedToAcceptedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyOfferStatusHasChangedToAcceptedNotification(){
        String titleOffer = new LoginCabinetPage()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickFirstPleaseAcceptOfferCard()
                .clickAcceptButton()
                .getOfferTitle();
        MainNotificationsOverlay mainNotificationsOverlay = new ClientDetailOfferPage()
                .clickLogOutLink()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("The offer \"%s\" has been accepted",
                titleOffer),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'The offer \"%s\" has been accepted' should be shown as last notification",
                        titleOffer));
    }

}
