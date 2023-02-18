package com.test.kanban.client_kanban;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CreateRequestOverlay {
    private final SelenideElement overlayTitle = $x("//h2[contains(text(), 'Create Task Request')]");
    private final SelenideElement createNewRequestButton = $x("//button[contains(text(), 'CREATE A NEW REQUEST')]");
    private final SelenideElement submitButton = $x("//button[contains(text(), 'SUBMIT')]");
    private final SelenideElement titleField = $x("//input[contains(@placeholder, 'Title')]");
    private final SelenideElement descriptionField = $x("//body[contains(@id, 'tinymce')]");
    private final SelenideElement requestDescriptionIframe = $x("//iframe[contains(@id, 'tiny-react')]");

    public String getOverlayTitle(){
        return overlayTitle.getText();
    }

    public CreateRequestOverlay clickCreateNewRequestButton(){
        sleep(2000);
        createNewRequestButton.click();
        sleep(5000);
        return new CreateRequestOverlay();
    }

    public ClientDetailRequestPage clickSubmitButton(){
        submitButton.click();
        sleep(5000);
        return new ClientDetailRequestPage();
    }

    public CreateRequestOverlay setTitleField(String title){
        titleField.val(title);
        return this;
    }

    public CreateRequestOverlay setDescriptionField(String title){
        descriptionField.val(title);
        return this;
    }

    public CreateRequestOverlay switchToDescriptionIframe(){
        switchTo().frame(requestDescriptionIframe);
        return this;
    }

    public CreateRequestOverlay switchFocusToOverlay(){
        switchTo().parentFrame();
        return this;
    }

}
