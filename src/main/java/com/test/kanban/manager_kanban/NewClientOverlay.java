package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class NewClientOverlay {
    private final SelenideElement enterClientEmailField = $x("//input[contains(@placeholder, 'email')]");
    private final SelenideElement addNewClientButton = $x("//button[contains(text(), 'Add new client')]");
    private final SelenideElement submitButton = $x("//button[contains(text(), 'Submit')]");

    public String getEnterClientEmailField() {
        return enterClientEmailField.getText();
    }

    public NewClientOverlay setEnterClientEmailField(String email){
        enterClientEmailField.val(email);
        sleep(2000);
        return this;
    }

    public NewClientOverlay clickAddNewClientButtonWithWrongEmail(){
        addNewClientButton.click();
        return this;
    }

    public NewClientOverlay clickAddNewClientButton(){
        addNewClientButton.click();
        sleep(4000);
        return this;
    }

    public ManagerKanbanPage clickSubmitButton(){
        submitButton.click();
        sleep(2000);
        return new ManagerKanbanPage();
    }

}
