package com.test;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageAdminPage extends BasePage {

    static void enteringAdminLoginData(){
        open(ADMIN_LINK);
        $("#adminloginform-username").val(ADMIN_USERNAME);
        $("#adminloginform-password").val(ADMIN_PASSWORD);
        $("button.btn").click();
        sleep(2000);
    }

}
