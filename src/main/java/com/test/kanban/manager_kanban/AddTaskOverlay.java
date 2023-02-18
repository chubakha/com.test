package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class AddTaskOverlay {

    private final SelenideElement titleField = $x("//input[contains(@placeholder, 'Title')]");
    private final SelenideElement priceField = $x("//input[contains(@placeholder, 'Price')]");
    private final SelenideElement timeField = $x("//input[contains(@placeholder, 'Time')]");
    private final SelenideElement taskStatusDropdown = $x("//label[contains(text(), 'Status')]/following-sibling::div");
    private final SelenideElement inProgressStatusOption = $x("//*[contains(text(), 'In Progress') and contains(@id, 'option-1')]");
    private final SelenideElement saveButton = $x("//button[contains(text(), 'SAVE')]");

    public AddTaskOverlay setTitleField(String title){
        titleField.val(title);
        return this;
    }

    public AddTaskOverlay setPriceField(String price){
        priceField.val(price);
        return this;
    }

    public AddTaskOverlay setTimeField(String time){
        timeField.val(time);
        return this;
    }

    public void clickSaveButton(){
        saveButton.click();
        sleep(2000);
    }

    public ManagerDetailOfferPage clickSaveButtonWithRedirection(){
        clickSaveButton();
        sleep(1000);
        return new ManagerDetailOfferPage();
    }

    public AddTaskOverlay clickSaveButtonWithoutRedirection(){
        clickSaveButton();
        return this;
    }

    public AddTaskOverlay clickTaskStatusDropdown(){
        taskStatusDropdown.click();
        sleep(500);
        return this;
    }

    public AddTaskOverlay clickStatusSelect(){
        inProgressStatusOption.click();
        return this;
    }

}
