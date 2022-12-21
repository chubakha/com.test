package com.test.setting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ChoicePaymentMethodPage {
    private final SelenideElement numberLabel = $x("//*[contains(@class, 'checkout__header-name')]/h3");
    private final SelenideElement serviceLabel = $x("//*[contains(text(), 'Service')]/following-sibling::div");
    private final SelenideElement createdDateLabel = $x("//*[contains(text(), 'Created date')]/following-sibling::div");
    private final SelenideElement dueDateLabel = $x("//*[contains(text(), 'Due date')]/following-sibling::div");
    private final SelenideElement priceLabel = $x("//*[contains(@class, 'total-value')]");
    private final SelenideElement personalCardPaymentMethodOption = $x("//*[contains(text(), 'Personal CREDIT CARD')]");
    private final SelenideElement corporateCardPaymentMethodOption = $x("//*[contains(text(), 'Corporate CREDIT CARD')]");
    private final SelenideElement bankTransferMethodOption = $x("//*[contains(text(), 'BANK TRANSFER')]");
    private final SelenideElement goToPaymentButton = $x("//button[contains(text(), 'go to payment')]");

    public String getCreatedDateLabel(){
        return createdDateLabel.getText();
    }

    public String getDueDateLabel(){
        return dueDateLabel.getText();
    }

    public ChoicePaymentMethodPage clickPersonalCardPaymentMethodOption(){
        personalCardPaymentMethodOption.click();
        return this;
    }

    public ChoicePaymentMethodPage clickCorporateCardPaymentMethodOption(){
        corporateCardPaymentMethodOption.click();
        return this;
    }

    public ChoicePaymentMethodPage clickBankTransferMethodPaymentMethodOption(){
        bankTransferMethodOption.click();
        return this;
    }

    public BillingInfoOverlay clickGoToPaymentButton(){
        goToPaymentButton.click();
        return new BillingInfoOverlay();
    }

}
