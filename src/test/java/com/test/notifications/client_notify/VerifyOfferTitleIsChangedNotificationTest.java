package com.test.notifications.client_notify;

import com.test.kanban.manager_kanban.EditOfferOverlay;
import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyOfferTitleIsChangedNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyOfferTitleIsChangedNotification(){
        EditOfferOverlay editOfferOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstOfferCard()
                .clickEditOfferLink();
        String oldTitle = editOfferOverlay.getTitleField();
        String newTitle = faker.lorem().sentence();
        MainNotificationsOverlay mainNotificationsOverlay = new EditOfferOverlay()
                .setTitleField(newTitle)
                .clickSubmitButton()
                .clickSendCommentButton()
                .clickLegalBoardLink()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("The offer \"%s\" has been renamed to \"%s\"",
                oldTitle, newTitle),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'The offer \"%s\" has been renamed to \"%s\"' should be shown as last notifications",
                        oldTitle, newTitle));
    }

}
