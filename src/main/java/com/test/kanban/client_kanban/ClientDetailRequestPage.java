package com.test.kanban.client_kanban;

import com.codeborne.selenide.SelenideElement;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class ClientDetailRequestPage {
    private final SelenideElement requestStatus = $x("//div[contains(@class, 'client_kanbanStep_notifications')]/span");
    private final SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");
    private final SelenideElement commentFieldIframe = $x("//*[contains(@id, 'tiny-react') and contains(@id, 'ifr')]");
    private final SelenideElement commentField = $x("//*[contains(@id, 'tinymce')]/p");
    private final SelenideElement header = $x("//div[@class='header__left']");
    private final SelenideElement sendCommentButton = $x("//button[contains(@class, 'send-button')]");
    private final SelenideElement offerTitle = $x("//h2[contains(@class, 'heading')]");


    public String getRequestStatus(){
        return requestStatus.getText();
    }

    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        return new LoginCabinetPage();
    }

    public ClientDetailRequestPage switchToChatIframe(){
        switchTo().frame(commentFieldIframe);
        return this;
    }

    public ClientDetailRequestPage switchToRootContainerPage(){
        switchTo().parentFrame();
        return this;
    }

    public ClientDetailRequestPage setCommentField(String value){
        commentField.val(value);
        return this;
    }

    public ClientDetailRequestPage scrollToUpPage(){
        header.scrollIntoView(false);
        return this;
    }

    public ClientDetailRequestPage clickSendCommentButton(){
        sendCommentButton.click();
        sleep(3000);
        return this;
    }

    public String getOfferTitle(){
        return offerTitle.getText();
    }


}
