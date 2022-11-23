package com.test;

import com.codeborne.selenide.WebDriverRunner;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.forgot_password_mail.MailHogMainPage;
import com.test.forgot_password_mail.YopmailMainPage;
import com.test.login.LoginCabinetPage;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public abstract class GenericPage extends PrepareOverallData {

    public static LoginCabinetPage openLoginPage(){
        open(domainCabinet);
        return new LoginCabinetPage();
    }

    private static void setYopmailAcceptPolicyCookies(){
        Cookie ck = new Cookie("ycons", "+iJ1n871rYva6Fyg1/Lwtg9XDoswRYKzgMxi0K33NiiN5elOngR4CClMDnw06ulS");
        WebDriverRunner.getWebDriver().manage().addCookie(ck);
        refresh();
    }

    public static YopmailMainPage openYopmailPage(){
        open("https://yopmail.com/ru/");
        setYopmailAcceptPolicyCookies();
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
        open(domainAdminPanel);
        return new LoginAdminPage();
    }

    public static MainAdminPage openAdminPageWithoutAuthorization(){
        open(domainAdminPanel);
        return new MainAdminPage();
    }
}
