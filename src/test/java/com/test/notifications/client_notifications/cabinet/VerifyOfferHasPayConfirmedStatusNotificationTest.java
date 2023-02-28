package com.test.notifications.client_notifications.cabinet;

import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyOfferHasPayConfirmedStatusNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyOfferHasPayConfirmedNotification(){

        String title =  new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstAwaitingPaymentNextStepCard()
                .getOfferTitle();
        MainNotificationsOverlay mainNotificationsOverlay = new ManagerDetailOfferPage()
                .clickStatusesDropDown()
                .clickStartDeliveryStatusButton()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("Work has started on your offer: \"%s\"",
                title),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'Work has started on your offer: \"%s\"' should be shown as last notifications",
                        title));
    }

}
