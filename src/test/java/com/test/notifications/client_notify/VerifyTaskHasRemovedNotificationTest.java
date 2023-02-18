package com.test.notifications.client_notify;

import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyTaskHasRemovedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyTaskHasRemovedNotification(){
        String title = faker.lorem().sentence();
        MainNotificationsOverlay mainNotificationsOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstOfferHasToBeAcceptedNextStepCard()
                .clickAddTaskButton()
                .setTitleField(title)
                .setPriceField(String.valueOf(faker.number().numberBetween(100, 9999)))
                .setTimeField(faker.number().digit())
                .clickSaveButtonWithRedirection()
                .clickDeleteTaskButton(title)
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("Your task \"%s\" has been removed",
                title),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'Your task \"%s\" has been removed' should be shown as last notifications",
                        title));
    }

}
