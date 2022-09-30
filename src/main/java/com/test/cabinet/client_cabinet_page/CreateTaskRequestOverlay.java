package com.test.cabinet.client_cabinet_page;

import com.codeborne.selenide.SelenideElement;
import com.test.forgot_password_mail.YopmailIncomingMailPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class CreateTaskRequestOverlay {
    private final SelenideElement overlayTitle = $x("//h2[contains(text(), 'Create Task Request')]");
    private final SelenideElement createNewRequestButton = $x("//button[contains(text(), 'CREATE A NEW REQUEST')]");
    private final SelenideElement submitButton = $x("//button[contains(text(), 'SUBMIT')]");
    private final SelenideElement titleField = $x("//input[contains(@placeholder, 'Title')]");
    private final SelenideElement descriptionField = $x("//body[contains(@id, 'tinymce')]");
    private final SelenideElement requestDescriptionIframe = $x("//iframe[contains(@id, 'tiny-react')]");

    public String getOverlayTitle(){
        return overlayTitle.getText();
    }

    public CreateTaskRequestOverlay clickCreateNewRequestButton(){
        createNewRequestButton.click();
        return new CreateTaskRequestOverlay();
    }

    public DetailRequestPage clickSubmitButton(){
        submitButton.click();
        return new DetailRequestPage();
    }

    public CreateTaskRequestOverlay setTitleField(String title){
        titleField.val(title);
        return this;
    }

    public CreateTaskRequestOverlay setDescriptionField(String title){
        descriptionField.val(title);
        return this;
    }

    public CreateTaskRequestOverlay switchToDescriptionIframe(){
        switchTo().frame(requestDescriptionIframe);
        return this;
    }

    public CreateTaskRequestOverlay switchFocusToOverlay(){
        switchTo().parentFrame();
        return this;
    }

}
