package com.test.notifications.client_notify;

import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyTaskStatusHasChangedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyTaskStatusHasChangedNotification(){
        String title = faker.lorem().sentence();
        MainNotificationsOverlay mainNotificationsOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstOfferCard()
                .clickAddTaskButton()
                .setTitleField(title)
                .setPriceField(String.valueOf(faker.number().numberBetween(100, 9999)))
                .setTimeField(faker.number().digit())
                .clickSaveButtonWithRedirection()
                .clickEditTaskButton(title)
                .clickTaskStatusDropdown()
                .clickStatusSelect()
                .clickSaveButtonWithRedirection()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("Your task \"%s\" has had a status update from \"To Do\" to \"In Progress\"",
                title),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'Your task \"%s\" has had a status update from \"To Do\" to \"In Progress\"' should be shown as last notifications",
                        title));
    }

}
