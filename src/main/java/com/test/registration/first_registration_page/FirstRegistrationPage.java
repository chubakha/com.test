package com.test.registration.first_registration_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.test.registration.Functions;
import com.test.registration.second_registration_page.SecondRegistrationPage;

import java.util.ArrayList;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class FirstRegistrationPage {
    private ElementsCollection toolTipIcons = $$x("//div[contains(@class,'FirstStep_firstStepBlockHeading')]/div[contains(@class,'FirstStep_firstStepBlockTooltip')]");
    private ElementsCollection toolTipText = $$x("//div[contains(@class,'FirstStep_firstStepBlockTooltipDropDown')]");
    private ElementsCollection selectedOptions = $$x("//div[contains(@class, 'checkbox_containerActive')]/following-sibling::span");
    private SelenideElement disabledNextButton = $x("//button[contains(@class, 'nextButton')and(@disabled)]");
    private SelenideElement enabledNextButton = $x("//button[contains(@class, 'nextButton')and not(@disabled)]");
    private SelenideElement needHelpWithSomethingElseButton = $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]");
    private SelenideElement addedNeedHelpWithSomethingElseText = $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]/div/div[2]/div/span");
    private SelenideElement needHelpWithSomethingElseTitle = $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]/div/div[1]");
    private SelenideElement pageTitle = $x("//*[text() = 'What do you need legally solved?']");
    private SelenideElement stepNumber = $x("//div[contains(@class, 'header-container')]/b");
    private SelenideElement needHelpWithSomethingElsePopupTitle = $x("//*[contains(@class, 'slide-enter-done')]");
    private SelenideElement backButton = $x("//*[text() = 'back']");


    public FirstRegistrationPage selectOneCheckboxInEverySection() {
        selectRandomIncorporationCheckBox()
                .selectRandomAccountingAndTaxesCheckbox()
                .selectRandomHiringCheckbox()
                .selectRandomIpprotectionCheckbox()
                .selectRandomClientAcquisitionCheckbox()
                .selectRandomPrivacyGdprComplianceCheckbox()
                .selectRandomFundraisingCheckbox()
                .selectRandomTokenGenerationDistributionCheckbox()
                .selectRandomLaunchingDaoWeb3Checkbox();
        return this;
    }

    public FirstRegistrationPage selectAllCheckboxInEverySection() {
        selectAllIncorporationCheckbox()
                .selectAllAccountingAndTaxesCheckbox()
                .selectAllHiringCheckbox()
                .selectAllIpprotectionCheckbox()
                .selectAllClientAcquisitionCheckbox()
                .selectAllPrivacygdprcomplianceCheckbox()
                .selectAllFundraisingCheckbox()
                .selectAllTokenGenerationDistributionCheckbox()
                .selectAllLaunchingDaoWeb3CheckboxCheckbox();
        return this;
    }

    public FirstRegistrationPage selectRandomIncorporationCheckBox() {
        int randomIncorporation = getRandomOneOption(3);
        IncorporationValuesType incorporationValue = IncorporationValuesType.values()[randomIncorporation];
        selectOption(incorporationValue.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomAccountingAndTaxesCheckbox() {
        int randomAccountingAndTaxes = getRandomOneOption(5);
        AccountingAndTaxesValueType accountingAndTaxesValue = AccountingAndTaxesValueType.values()[randomAccountingAndTaxes];
        selectOption(accountingAndTaxesValue.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomHiringCheckbox() {
        int randomHiring = getRandomOneOption(4);
        HiringValueType hiringValue = HiringValueType.values()[randomHiring];
        selectOption(hiringValue.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomIpprotectionCheckbox() {
        int randomIpprotection = getRandomOneOption(2);
        IpprotectionValueType ipprotectionValue = IpprotectionValueType.values()[randomIpprotection];
        selectOption(ipprotectionValue.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomClientAcquisitionCheckbox() {
        int randomClientAcquisition = getRandomOneOption(3);
        ClientAcquisitionValueType clientAcquisitionValue = ClientAcquisitionValueType.values()[randomClientAcquisition];
        selectOption(clientAcquisitionValue.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomPrivacyGdprComplianceCheckbox() {
        int randomPrivacygdprcompliance = getRandomOneOption(3);
        PrivacygdprcomplianceValueType privacygdprcomplianceValue = PrivacygdprcomplianceValueType.values()[randomPrivacygdprcompliance];
        selectOption(privacygdprcomplianceValue.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomFundraisingCheckbox() {
        int randomFundraising = getRandomOneOption(4);
        FundraisingValueType fundraisingValue = FundraisingValueType.values()[randomFundraising];
        selectOption(fundraisingValue.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomTokenGenerationDistributionCheckbox() {
        int randomTokenGenerationDistribution = getRandomOneOption(4);
        TokenGenerationDistributionValueType tokenGenerationDistributionValue = TokenGenerationDistributionValueType.values()[randomTokenGenerationDistribution];
        selectOption(tokenGenerationDistributionValue.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomLaunchingDaoWeb3Checkbox() {
        int randomLaunchingDaoWeb3 = getRandomOneOption(4);
        LaunchingDaoWeb3ValueType launchingDaoWeb3Value = LaunchingDaoWeb3ValueType.values()[randomLaunchingDaoWeb3];
        selectOption(launchingDaoWeb3Value.getValue());
        return this;
    }

    public FirstRegistrationPage selectAllIncorporationCheckbox() {
        for (IncorporationValuesType incorporationValue : IncorporationValuesType.values()) {
            selectOption(incorporationValue.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllAccountingAndTaxesCheckbox() {
        for (AccountingAndTaxesValueType accountingandtaxesValue : AccountingAndTaxesValueType.values()) {
            selectOption(accountingandtaxesValue.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllHiringCheckbox() {
        for (HiringValueType hiringValue : HiringValueType.values()) {
            selectOption(hiringValue.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllIpprotectionCheckbox() {
        for (IpprotectionValueType ipprotectionValue : IpprotectionValueType.values()) {
            selectOption(ipprotectionValue.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllClientAcquisitionCheckbox() {
        for (ClientAcquisitionValueType clientAcquisitionValue : ClientAcquisitionValueType.values()) {
            selectOption(clientAcquisitionValue.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllPrivacygdprcomplianceCheckbox() {
        for (PrivacygdprcomplianceValueType privacygdprcomplianceValue : PrivacygdprcomplianceValueType.values()) {
            selectOption(privacygdprcomplianceValue.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllFundraisingCheckbox() {
        for (FundraisingValueType fundraisingValue : FundraisingValueType.values()) {
            selectOption(fundraisingValue.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllTokenGenerationDistributionCheckbox() {
        for (TokenGenerationDistributionValueType tokenGenerationDistributionValue : TokenGenerationDistributionValueType.values()) {
            selectOption(tokenGenerationDistributionValue.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllLaunchingDaoWeb3CheckboxCheckbox() {
        for (LaunchingDaoWeb3ValueType daoWeb3CheckboxValue : LaunchingDaoWeb3ValueType.values()) {
            selectOption(daoWeb3CheckboxValue.getValue());
        }
        return this;
    }

    public FirstRegistrationPage hoverOnEveryToolTipIcon() {
        //boolean[] toolTipTextArray = new boolean[toolTipIcons.size()];
        ArrayList<String> toolTipTextArray = new ArrayList<String>();
        for (int i = 0; i < toolTipIcons.size(); i++) {
            toolTipIcons.get(i).hover();
            toolTipText.get(i).shouldBe(Condition.appear);
            toolTipTextArray.add(Boolean.toString(toolTipText.get(i).isDisplayed()));
        }
        return this;
    }

    public String[] getAllToolTipsText() {
        String[] textHintArray = new String[toolTipText.size()];
        for (int i = 0; i < toolTipText.size(); i++) {
            textHintArray[i] = toolTipText.get(i).innerText();
        }
        return textHintArray;
    }

    public int getRandomOneOption(int amount) {
        return new Random().nextInt(amount);
    }

    public FirstRegistrationPage selectOption(String value) {
        //написать интерфейс с Владом
        String xpath = String.format("//*[text() = '%s']", value);
        $x(xpath).click();
        return this;
    }

    public FirstRegistrationPage selectOneRandomOption() {
        int randomOption = new Random().nextInt(30) + 1;
        $x("(//span[contains(@class,'checkbox_label')])[" + randomOption + "]").click();
        return this;
    }

    public FirstRegistrationPage clickDisabledNextButton() {
        disabledNextButton.click();
        return this;
    }

    public SecondRegistrationPage clickEnabledNextButton() {
        enabledNextButton.shouldNotBe(Condition.attribute("disabled")).click();
        return new SecondRegistrationPage();
    }

    public CreateCustomRequestOverlay clickNeedHelpWithSomethingElseButton() {
        needHelpWithSomethingElseButton.click();
        return new CreateCustomRequestOverlay();
    }

    public FirstRegistrationPage deleteNeedHelpWithSomethingElse() {
        addedNeedHelpWithSomethingElseText.click();
        return this;
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getStepNumber() {
        return stepNumber.shouldHave(Condition.text("1/4")).getText();
    }

    public String getAddedNeedHelpWithSomethingElse() {
        return addedNeedHelpWithSomethingElseText.getText();
    }

    public String getNeedHelpWithSomethingElseTitle() {
        return needHelpWithSomethingElseTitle.getText();
    }

    public boolean isNotNeedHelpWithSomethingElsePopupShown() {
        return needHelpWithSomethingElsePopupTitle.isDisplayed();
    }

    public String[] getSelectedOptions() {
        backButton.shouldNotBe(Condition.exist);
        return new Functions().getChosenOptions(selectedOptions);
    }

}
