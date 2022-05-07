package com.test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class ClientsAdminPage {

    static void goToClientPageAdmin(){
        $("[href='/users/client/index']").click();
    }

    static void goToLasClientPageAdmin(){
        $x(".//ul[@class='pagination']/li[last()-1]/a").click();
    }

    static void goToEditClientAdmin(String email){
        $x("//td[contains(text(),'" + email+ "')]/../td[last()]/a[2]").click();
    }

    static void doActiveClientAdmin(){
        $("#userform-status").selectOption(1);
    }

    static void saveClientAdmin(){
        $x("//button[contains(text(),'Save')]").click();
    }

}
