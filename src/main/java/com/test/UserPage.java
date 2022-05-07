package com.test;

import static com.codeborne.selenide.Selenide.*;

public class UserPage {
    public void logoutClickButton() {
        $(".layout__sidebar-profile_logout").click();
    }
}