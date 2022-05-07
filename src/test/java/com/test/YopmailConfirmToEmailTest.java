package com.test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class YopmailConfirmToEmailTest {
    @Test
    void emailConfirm(){
        open("https://yopmail.com/ru/wm");
        YopmailComfirmToEmailPage.enterToEmail();

    }
}
