package com.test.kanban.notifications;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainNotificationsOverlay {

    private final SelenideElement lastMessage = $x("//div[@class = 'notification__item'][last()]/a[contains(@class, 'notification__item-text')]/p");

    public String getLastMessage(){
        return lastMessage.text();
    }
}
