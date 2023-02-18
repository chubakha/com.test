package com.test.notifications.client_notify;

import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyTaskPriceHasChangedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyTaskPriceHasChangedNotification(){
        String oldPrice = String.valueOf(faker.number().numberBetween(100, 9999));
        String newPrice = String.valueOf(faker.number().numberBetween(100, 9999));
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
                .setPriceField(oldPrice)
                .setTimeField(faker.number().digit())
                .clickSaveButtonWithRedirection()
                .clickEditTaskButton(title)
                .setPriceField(newPrice)
                .clickSaveButtonWithRedirection()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("Your task \"%s\" has had a price update from \"%s\" to \"%s\"",
                title, oldPrice, newPrice),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'Your task \"%s\" has had a price update from \"%s\" to \"%s\"' should be shown as last notifications",
                        title, oldPrice, newPrice));
    }

}
