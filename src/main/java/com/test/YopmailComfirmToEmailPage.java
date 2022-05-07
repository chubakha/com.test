package com.test;

import static com.codeborne.selenide.Selenide.*;

public class YopmailComfirmToEmailPage extends BasePage {

    public static void enterToEmail() {
        $(".tooltip.click input").val(YOPMAIL_EMAIL);
        $(".material-icons-outlined.f36").click();

    }
}
