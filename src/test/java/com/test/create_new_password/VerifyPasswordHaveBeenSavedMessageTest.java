package com.test.create_new_password;

import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.forgot_password_mail.MailHogIncomingPage;
import com.test.forgot_password_mail.MailHogMainPage;
import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import com.test.forgot_password_mail.YopmailIncomingMailPage;
import com.test.forgot_password_mail.YopmailMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyPasswordHaveBeenSavedMessageTest extends PrepareLoginTestData {

    @Test
    void verifyPasswordHaveBeenSavedMessage(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(clientEmail);
        sleep(2000);
        String password = faker.internet().password(8, 15);
        CreateNewPasswordOverlay createNewPasswordOverlay = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton();
        Assertions.assertEquals("Password have been saved", createNewPasswordOverlay.getPasswordHaveBeenSavedTitle(),
                "'Password have been saved' should be shown");
        localStorage().clear();
    }

    @AfterAll
    static void resetPasswordToDefault(){
        PrepareAdminPanelTestData.openLoginAdminPage();
        new LoginAdminPage()
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
        sleep(1000);
        new MainAdminPage().clickLogoutLink();
        sleep(1000);
    }

}
