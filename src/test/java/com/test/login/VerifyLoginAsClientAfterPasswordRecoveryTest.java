package com.test.login;

import com.test.GenericPage;
import com.test.admin_panel.MainAdminPage;
import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyLoginAsClientAfterPasswordRecoveryTest extends PrepareLoginTestData{

    public static String password = faker.internet().password(8, 15);

    @Test
    void verifyLoginAsClientAfterPasswordRecovery(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(clientEmail);
        sleep(2000);

        new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton();
        ClientCabinetPage clientCabinetPage = new LoginCabinetPage()
                .setEmailField(clientEmail)
                .setPasswordField(password)
                .loginAsClient();
        Assertions.assertTrue(clientCabinetPage.isTaskRequestButtonShown(),
                String.format("'%s' button should be shown", clientCabinetPage.getTaskRequestButtonText()));
        localStorage().clear();
    }

    @AfterEach
    void resetPasswordToDefault(){
        GenericPage
                .openLoginAdminPage()
                .setUsernameField(usernameAdmin)
                .setPasswordField(passwordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(clientEmail)
                .focusOutSearchFields()
                .clickUpdateButton()
                .setPasswordField(clientPassword)
                .setRepeatPasswordField(clientPassword)
                .clickSaveButton();
        sleep(2000);
        new MainAdminPage().clickLogoutLink();
        sleep(1000);
    }

}
