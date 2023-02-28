package com.test.notifications.client_notifications.cabinet;

import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyTaskTitleHasChangedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyTaskTitleHasChangedNotification(){
        String oldTitle = faker.lorem().sentence();
        String newTitle = faker.lorem().sentence();
        MainNotificationsOverlay mainNotificationsOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstOfferCard()
                .clickAddTaskButton()
                .setTitleField(oldTitle)
                .setPriceField(String.valueOf(faker.number().numberBetween(100, 9999)))
                .setTimeField(faker.number().digit())
                .clickSaveButtonWithRedirection()
                .clickEditTaskButton(oldTitle)
                .setTitleField(newTitle)
                .clickSaveButtonWithRedirection()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("Your task \"%s\" has been renamed: \"%s\"",
                oldTitle, newTitle),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'Your task \"%s\" has been renamed: \"%s\"' should be shown as last notifications",
                        oldTitle, newTitle));
    }

}
