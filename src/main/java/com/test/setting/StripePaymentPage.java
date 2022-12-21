package com.test.setting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StripePaymentPage {

    private final SelenideElement vatLabel = $x("//span[contains(@class,'subtotalItemLabel')]");
    private final SelenideElement creditCardNumberField = $x("//input[contains(@id, 'cardNumber')]");
    private final SelenideElement cardExpiryField = $x("//input[contains(@id, 'cardExpiry')]");
    private final SelenideElement cardCvcField = $x("//input[contains(@id, 'cardCvc')]");
    private final SelenideElement cardHolderField = $x("//input[contains(@id, 'billingName')]");
    private final SelenideElement payButton = $x("//*[@class = 'SubmitButton-IconContainer']");

    public StripePaymentPage setCreditCardNumberField(String creditCardNumber){
        creditCardNumberField.val(creditCardNumber);
        return this;
    }

    public StripePaymentPage setCardExpiryField(String cardExpiry){
        cardExpiryField.val(cardExpiry);
        return this;
    }

    public StripePaymentPage setCardCvcField(String cardCvc){
        cardCvcField.val(cardCvc);
        return this;
    }

    public StripePaymentPage setCardHolderField(String billingName){
        cardHolderField.val(billingName);
        return this;
    }

    public InvoicesListPage clickPayButton(){
        payButton.click();
        return new InvoicesListPage();
    }

    public String getVatLabel(){
        return vatLabel.getText();
    }


}
