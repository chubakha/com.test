package com.test.registration.first_registration_page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.test.registration.Functions;
import com.test.registration.second_registration_page.SecondRegistrationPage;

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
    private SelenideElement stepNumber = $x("//div[@class='registration-quiz__header-container']/b");
    private SelenideElement needHelpWithSomethingElsePopupTitle = $x("//*[contains(@class, 'slide-enter-done')]");

    public boolean[] toolTipTextArray = new boolean[toolTipIcons.size()];


    public FirstRegistrationPage selectOneCheckboxInEverySection() {
        selectRandomIncorporationCheckBox();
        selectRandomAccountingAndTaxesCheckbox();
        selectRandomHiringCheckbox();
        selectRandomIpprotectionCheckbox();
        selectRandomClientAcquisitionCheckbox();
        selectRandomPrivacyGdprComplianceCheckbox();
        selectRandomFundraisingCheckbox();
        selectRandomTokenGenerationDistributionCheckbox();
        selectRandomLaunchingDaoWeb3Checkbox();
        return this;
    }

    public FirstRegistrationPage selectAllCheckboxInEverySection() {
        selectAllIncorporationCheckbox();
        selectAllAccountingAndTaxesCheckbox();
        selectAllHiringCheckbox();
        selectAllIpprotectionCheckbox();
        selectAllClientAcquisitionCheckbox();
        selectAllPrivacygdprcomplianceCheckbox();
        selectAllFundraisingCheckbox();
        selectAllTokenGenerationDistributionCheckbox();
        selectAllLaunchingDaoWeb3CheckboxCheckbox();
        return this;
    }

    public FirstRegistrationPage selectRandomIncorporationCheckBox() {
        int randomIncorporation = getRandomOneOption(3);
        IncorporationValuesType incorporation = IncorporationValuesType.values()[randomIncorporation];
        selectOption(incorporation.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomAccountingAndTaxesCheckbox() {
        int randomAccountingAndTaxes = getRandomOneOption(5);
        AccountingAndTaxesValueType accountingandtaxes = AccountingAndTaxesValueType.values()[randomAccountingAndTaxes];
        selectOption(accountingandtaxes.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomHiringCheckbox() {
        int randomHiring = getRandomOneOption(4);
        HiringValueType hiring = HiringValueType.values()[randomHiring];
        selectOption(hiring.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomIpprotectionCheckbox() {
        int randomIpprotection = getRandomOneOption(2);
        IpprotectionValueType ipprotection = IpprotectionValueType.values()[randomIpprotection];
        selectOption(ipprotection.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomClientAcquisitionCheckbox() {
        int randomClientAcquisition = getRandomOneOption(3);
        ClientAcquisitionValueType clientAcquisition = ClientAcquisitionValueType.values()[randomClientAcquisition];
        selectOption(clientAcquisition.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomPrivacyGdprComplianceCheckbox() {
        int randomPrivacygdprcompliance = getRandomOneOption(3);
        PrivacygdprcomplianceValueType privacygdprcompliance = PrivacygdprcomplianceValueType.values()[randomPrivacygdprcompliance];
        selectOption(privacygdprcompliance.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomFundraisingCheckbox() {
        int randomFundraising = getRandomOneOption(4);
        FundraisingValueType fundraising = FundraisingValueType.values()[randomFundraising];
        selectOption(fundraising.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomTokenGenerationDistributionCheckbox() {
        int randomTokenGenerationDistribution = getRandomOneOption(4);
        TokenGenerationDistributionValueType tokenGenerationDistribution = TokenGenerationDistributionValueType.values()[randomTokenGenerationDistribution];
        selectOption(tokenGenerationDistribution.getValue());
        return this;
    }

    public FirstRegistrationPage selectRandomLaunchingDaoWeb3Checkbox() {
        int randomLaunchingDaoWeb3 = getRandomOneOption(4);
        LaunchingDaoWeb3ValueType launchingDaoWeb3 = LaunchingDaoWeb3ValueType.values()[randomLaunchingDaoWeb3];
        selectOption(launchingDaoWeb3.getValue());
        return this;
    }

    public FirstRegistrationPage selectAllIncorporationCheckbox() {
        for (IncorporationValuesType incorporation : IncorporationValuesType.values()) {
            selectOption(incorporation.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllAccountingAndTaxesCheckbox() {
        for (AccountingAndTaxesValueType accountingandtaxes : AccountingAndTaxesValueType.values()) {
            selectOption(accountingandtaxes.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllHiringCheckbox() {
        for (HiringValueType hiring : HiringValueType.values()) {
            selectOption(hiring.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllIpprotectionCheckbox() {
        for (IpprotectionValueType ipprotection : IpprotectionValueType.values()) {
            selectOption(ipprotection.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllClientAcquisitionCheckbox() {
        for (ClientAcquisitionValueType clientAcquisition : ClientAcquisitionValueType.values()) {
            selectOption(clientAcquisition.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllPrivacygdprcomplianceCheckbox() {
        for (PrivacygdprcomplianceValueType privacygdprcompliance : PrivacygdprcomplianceValueType.values()) {
            selectOption(privacygdprcompliance.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllFundraisingCheckbox() {
        for (FundraisingValueType fundraising : FundraisingValueType.values()) {
            selectOption(fundraising.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllTokenGenerationDistributionCheckbox() {
        for (TokenGenerationDistributionValueType tokenGenerationDistribution : TokenGenerationDistributionValueType.values()) {
            selectOption(tokenGenerationDistribution.getValue());
        }
        return this;
    }

    public FirstRegistrationPage selectAllLaunchingDaoWeb3CheckboxCheckbox() {
        for (LaunchingDaoWeb3ValueType daoWeb3Checkbox : LaunchingDaoWeb3ValueType.values()) {
            selectOption(daoWeb3Checkbox.getValue());
        }
        return this;
    }

    public FirstRegistrationPage hoverOnEveryToolTipIcon(){
        for (int i = 0; i < toolTipIcons.size(); i++) {
            toolTipIcons.get(i).hover();
            toolTipTextArray[i] = toolTipText.get(i).isDisplayed();
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
        String xpath = String.format("//*[text() = '%s']", value);
        $x(xpath).click();
        return this;
    }

    public void selectOneRandomOption() {
        int randomOption = new Random().nextInt(9) + 1;
        $x("(//span[contains(@class,'checkbox_label')])[" + randomOption + "]").click();
    }

    public SecondRegistrationPage selectOneRandomOptionAndRedirectOnSecondRegistrationPage() {
        selectOneRandomOption();
        clickEnabledNextButton();
        return new SecondRegistrationPage();
    }

    public FirstRegistrationPage clickDisabledNextButton() {
        disabledNextButton.click();
        return this;
    }

    public SecondRegistrationPage clickEnabledNextButton() {
        enabledNextButton.click();
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
        return stepNumber.getText();
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
        String[] chosenOptionListOnFirstPage = new Functions().getChosenOptions(selectedOptions);
        return chosenOptionListOnFirstPage;
    }

}
