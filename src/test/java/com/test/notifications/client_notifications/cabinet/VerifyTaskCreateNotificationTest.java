package com.test.notifications.client_notifications.cabinet;

import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyTaskCreateNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyTaskCreateNotification(){
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
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("A new task \"%s\" has been created",
                title),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'A new task \"%s\" has been created' should be shown as last notifications",
                        title));
    }

}
