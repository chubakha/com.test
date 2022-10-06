package com.test;

import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.forgot_password_mail.MailHogMainPage;
import com.test.forgot_password_mail.YopmailMainPage;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.open;

public abstract class GenericPage {

    public static LoginCabinetPage openLoginPage(){
        open("https://stag.cabinet.legalnodes.co/");
        return new LoginCabinetPage();
    }

    public static YopmailMainPage openYopmailPage(){
        open("https://yopmail.com/ru/");
        return new YopmailMainPage();
    }

    public static MailHogMainPage openMailHogPage(){
        open("https://stag.mailer.legalnodes.co/");
        return new MailHogMainPage();
    }

    public static void openAnyLink(String link){
        open(link);
    }

    public static LoginAdminPage openLoginAdminPage(){
        open("https://stag.admin.legalnodes.co");
        return new LoginAdminPage();
    }

    public static MainAdminPage openAdminPageWithoutAuthorization(){
        open("https://stag.admin.legalnodes.co");
        return new MainAdminPage();
    }
}
