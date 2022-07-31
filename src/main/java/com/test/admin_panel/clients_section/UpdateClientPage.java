package com.test.admin_panel.clients_section;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class UpdateClientPage {
    private SelenideElement statusSelect = $x("//select[contains(@id, 'status')]");
    private SelenideElement sendButton = $x("//button[contains(text(), 'Save')]");

    public UpdateClientPage activateStatus(){
        statusSelect.selectOption(1);
        return this;
    }

    public ViewClientPage saveClient(){
        sendButton.click();
        return new ViewClientPage();
    }
}
