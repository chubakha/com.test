package com.test.notifications.client_notifications.cabinet;

import com.test.kanban.manager_kanban.EditRequestOverlay;
import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.*;

public class VerifyRequestTitleIsChangedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyRequestTitleIsChangedNotification(){
        EditRequestOverlay editRequestOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstRequestCard()
                .clickEditRequestLink();
        String oldTitle = editRequestOverlay.getTitleField();
        String newTitle = faker.lorem().sentence();
        MainNotificationsOverlay mainNotificationsOverlay = new EditRequestOverlay()
                .setTitleField(newTitle)
                .clickSubmitButton()
                .clickLegalBoardLink()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("The request \"%s\" has been renamed to \"%s\"",
                oldTitle, newTitle),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'The request \"%s\" has been renamed to \"%s\"' should be shown as last notification",
                        oldTitle, newTitle));
    }

}
