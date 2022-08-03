package com.test.cabinet.manager_cabinet_page;

import com.codeborne.selenide.SelenideElement;
import com.test.login.LoginCabinetPage;

import static com.codeborne.selenide.Selenide.$x;

public class ManagerCabinetPage {
    private SelenideElement newOfferButton = $x("//button[contains(text(), 'NEW OFFER')]");
    private SelenideElement logOutLink = $x("//*[contains(text(), 'Log out')]");

    public boolean isNewOfferButtonShown(){
        return newOfferButton.isDisplayed();
    }

    public String getNewOfferButtonText(){
        return newOfferButton.getText();
    }

    public LoginCabinetPage clickLogOutLink(){
        logOutLink.click();
        return new LoginCabinetPage();
    }

}
