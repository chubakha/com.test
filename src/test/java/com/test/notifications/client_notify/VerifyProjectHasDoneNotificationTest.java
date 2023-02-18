package com.test.notifications.client_notify;

import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyProjectHasDoneNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyProjectHasDoneNotification(){

        String title =  new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstProjectCard()
                .getOfferTitle();
        MainNotificationsOverlay mainNotificationsOverlay = new ManagerDetailOfferPage()
                .clickStatusesDropDown()
                .clickMoveToDoneStatusButton()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("Your project \"%s\" has been moved to \"Done\"",
                title),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'Your project \"%s\" has been moved to \"Done\"' should be shown as last notifications",
                        title));
    }

}
