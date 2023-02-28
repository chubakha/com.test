package com.test.notifications.client_notifications.cabinet;

import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyOfferHasAwaitingPaymentStatusNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyOfferHasAwaitingPaymentStatusNotification(){

        String title =  new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstAwaitingVloNextStepCard()
                .clickStatusesDropDown()
                .clickMoveToPaymentStatusButton()
                .getOfferTitle();
        MainNotificationsOverlay mainNotificationsOverlay = new ManagerDetailOfferPage()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("A pre-payment has been requested for the offer \"%s\"",
                title),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'A pre-payment has been requested for the offer \"%s\"' should be shown as last notifications",
                        title));
    }

}
