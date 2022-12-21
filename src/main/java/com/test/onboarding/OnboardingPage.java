package com.test.onboarding;

import com.codeborne.selenide.SelenideElement;
//import com.test.invoices.InvoicePage;

import static com.codeborne.selenide.Selenide.$x;

public class OnboardingPage {

    private final SelenideElement signLetterButton = $x("//button[contains(text(), 'Sign')]");
    private final SelenideElement payDeposit = $x("//button[contains(text(), 'Pay a deposit')]");
    private final SelenideElement bookCallButton = $x("//button[contains(text(), 'Book A Call')]");
    private final SelenideElement joinCallButton = $x("//button[contains(text(), 'Join to call')]");


    public HelloSignEmailPopupOverlay clickSignLetterButton() {
        signLetterButton.click();
        return new HelloSignEmailPopupOverlay();
    }

//    public InvoicePage clickPayDeposit() {
//        payDeposit.click();
//        return new InvoicePage();
//    }


}
