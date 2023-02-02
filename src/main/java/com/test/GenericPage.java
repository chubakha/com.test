package com.test;

import com.codeborne.selenide.WebDriverRunner;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.forgot_password_mail.MailHogMainPage;
import com.test.forgot_password_mail.YopmailMainPage;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.setting.InvoicesListPage;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;

public abstract class GenericPage extends PrepareOverallData {

    public static LoginCabinetPage openLoginPage(){
        open(domainCabinet);
        return new LoginCabinetPage();
    }

    public static ClientKanbanPage openClientKanban(){
        open(domainCabinet);
        sleep(4000);
        return new ClientKanbanPage();
    }

    public static ManagerKanbanPage openManagerKanban(){
        open(domainCabinet);
        sleep(4000);
        return new ManagerKanbanPage();
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
        sleep(4000);
        return new MailHogMainPage();
    }

    public static void openAnyLink(String link){
        open(link);
        sleep(2000);
    }

    public static LoginAdminPage openLoginAdminPage(){
        open(domainAdminPanel);
        return new LoginAdminPage();
    }

    public static MainAdminPage openAdminPageWithoutAuthorization(){
        open(domainAdminPanel);
        return new MainAdminPage();
    }

    public static InvoicesListPage openClientInvoicesPage(){
        open(domainCabinet + "/settings/history");
        return new InvoicesListPage();
    }
}
