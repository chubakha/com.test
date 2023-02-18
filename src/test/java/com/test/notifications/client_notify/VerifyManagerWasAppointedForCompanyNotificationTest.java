package com.test.notifications.client_notify;

import com.test.GenericPage;
import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.*;

public class VerifyManagerWasAppointedForCompanyNotificationTest extends PrepareClientNotificationsData {

    @BeforeAll
    static void appointNoManagerToClient(){
        GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickCompaniesLink()
                .setClientSearchByCompanyField(dataGenerationClientNotificationsCompany)
                .focusOutSearchFields()
                .clickUpdateButton()
                .clickManagerSelect()
                .clickCertainManagerOption("no manager")
                .clickSaveButton();
    }

    @Test
    void verifyManagerWasAppointedForCompanyNotification(){

        MainNotificationsOverlay mainNotificationsOverlay = GenericPage
                .openLoginPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickNewClientButton()
                .setEnterClientEmailField(dataGenerationClientNotificationsEmail)
                .clickAddNewClientButton()
                .clickSubmitButton()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("Added new manager \"%s\" to your company \"%s\"",
                dataGenerationManagerFirstName + " " + dataGenerationManagerLastName,
                dataGenerationClientNotificationsCompany),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'Added new manager \"%s\" to your company \"%s\"' should be shown as last notification",
                        dataGenerationManagerFirstName + " " + dataGenerationManagerLastName,
                        dataGenerationClientNotificationsCompany));
    }

    @AfterAll
    static void appointDataGenerationManagerToClient(){
        GenericPage
                .openAdminPageWithoutAuthorization()
                .clickCompaniesLink()
                .setClientSearchByCompanyField(dataGenerationClientNotificationsCompany)
                .focusOutSearchFields()
                .clickUpdateButton()
                .clickManagerSelect()
                .clickCertainManagerOption(dataGenerationManagerFirstName + " " + dataGenerationManagerLastName)
                .clickSaveButton();
    }

}
