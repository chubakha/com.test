package com.test.notifications.client_notify;

import com.test.kanban.OfferStatusesType;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyOfferChangedStatusFromDoneToUnDoneNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyOfferChangedStatusFromDoneToUnDoneNotification(){

        String title = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstDoneProjectCard()
                .clickReturnToInProgressButton()
                .getOfferTitle();
        MainNotificationsOverlay mainNotificationsOverlay = new ManagerDetailOfferPage()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("Your project \"%s\" has been moved from \"%s\" to \"%s\"",
                title, OfferStatusesType.DONE.getValue(), OfferStatusesType.IN_PROGRESS.getValue()),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'Your project \"%s\" has been moved from \"%s\" to \"%s\"' should be shown as last notifications",
                        title, OfferStatusesType.DONE.getValue(), OfferStatusesType.IN_PROGRESS.getValue()));
    }

}
