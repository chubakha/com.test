package com.test.registration;

import com.codeborne.selenide.ElementsCollection;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
//import com.test.registration.depreciated.first_registration_page.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class Functions {
/*    public String[] getChosenOptions(ElementsCollection selectedOptions) {
        String[] chosenList = new String[selectedOptions.size()];
        for (int i = 0; i < chosenList.length; i++) {
            chosenList[i] = selectedOptions.get(i).getText();
        }
        return chosenList;
    }

    public boolean compareSectionAndOption(String chosenOption, String chosenSection) {
        ListMultimap<String, String> sectionsAndOptionsArray = ArrayListMultimap.create();
        Map<String, Collection<String>> map = Map.of(
                CategoriesType.INCORPORATION.getValue(), Arrays.asList(IncorporationValuesType.PICK_THE_BEST_JURISDICTIONS_AND_CORPORATE_STRUCTURE_FOR_MY_TECH_PROJECT.getValue(),
                        IncorporationValuesType.REGISTER_A_COMPANY_FOR_INITIAL_FUNDRAISING_AND_GO_TO_MARKET.getValue(),
                        IncorporationValuesType.REGISTER_A_COMPANY_FOR_INITIAL_FUNDRAISING_AND_GO_TO_MARKET.getValue()),
                CategoriesType.ACCOUNTING_TAXES.getValue(), Arrays.asList(AccountingAndTaxesValueType.GET_TAXATION_ANALYSIS_ON_THE_COUNTRY_CHOSEN_FOR_COMPANY_REGISTRATION.getValue(),
                        AccountingAndTaxesValueType.OBTAIN_A_COMPANY_TAX_NUMBER.getValue(),
                        AccountingAndTaxesValueType.START_ISSUING_AND_COLLECTING_INVOICES_IN_A_TAX_COMPLIANT_WAY.getValue(),
                        AccountingAndTaxesValueType.SET_UP_ACCOUNTING_FOR_PAYING_SALARIES.getValue(),
                        AccountingAndTaxesValueType.OBTAIN_COMPANY_VAT_NUMBER.getValue()),
                CategoriesType.HIRING.getValue(), Arrays.asList(HiringValueType.HIRE_A_NEW_TEAM_MEMBER.getValue(),
                        HiringValueType.PROTECT_INTELLECTUAL_PROPERTY_AND_TRADE_SECRETS.getValue(),
                        HiringValueType.INCENTIVIZE_THE_TEAM_BY_ISSUING_SHARE_OPTIONS.getValue(),
                        HiringValueType.ENGAGE_A_NEW_CONTRACTOR.getValue()),
                CategoriesType.IP_PROTECTION.getValue(), Arrays.asList(IpprotectionValueType.PROTECT_THE_NAME_AND_LOGO_OF_THE_COMPANY.getValue(),
                        IpprotectionValueType.PROTECT_THE_NAME_AND_LOGO_OF_THE_COMPANY.getValue()),
                CategoriesType.CLIENT_ACQUISITION.getValue(), Arrays.asList(ClientAcquisitionValueType.START_USER_ACQUISITION_ON_THE_WEBSITE_APP.getValue(),
                        ClientAcquisitionValueType.START_RECEIVING_PAYMENTS_FROM_B2B_CLIENTS.getValue(),
                        ClientAcquisitionValueType.START_WORKING_WITH_A_NEW_REFERRAL_PARTNER.getValue()),
                CategoriesType.PRIVACY_GDPR_COMPLIANCE.getValue(), Arrays.asList(PrivacygdprcomplianceValueType.MAKE_THE_WEBSITE_APP_COMPLIANT_WITH_PRIVACY_LAWS.getValue(),
                        PrivacygdprcomplianceValueType.START_WORKING_WITH_EU_BASED_CLIENTS_AND_USERS.getValue(),
                        PrivacygdprcomplianceValueType.SIGN_B2B_AGREEMENTS_WITH_EU_BASED_CLIENTS.getValue()),
                CategoriesType.FUNDRAISING.getValue(), Arrays.asList(FundraisingValueType.PREPARE_FOR_THE_FUNDRAISING.getValue(),
                        FundraisingValueType.RAISE_INVESTMENTS.getValue(),
                        FundraisingValueType.RAISE_INVESTMENTS_WITH_THE_PROMISE_TO_ISSUE_TOKENS.getValue(),
                        FundraisingValueType.MAKE_A_CASH_OUT_EXIT.getValue()),
                CategoriesType.TOKEN_GENERATION_DISTRIBUTION_WEB3.getValue(), Arrays.asList(TokenGenerationDistributionValueType.REGISTER_A_COMPANY_TO_ISSUE_THE_TOKENS.getValue(),
                        TokenGenerationDistributionValueType.ENSURING_REGULATORY_AND_AML_COMPLIANCE_WHEN_SELLING_TOKENS.getValue(),
                        TokenGenerationDistributionValueType.PUBLIC_TOKEN_DISTRIBUTION_THROUGH_LAUNCHPADS_LISTING_TOKENS_ON_CRYPTO_EXCHANGES.getValue(),
                        TokenGenerationDistributionValueType.LAUNCHING_DEFI_AND_TOKEN_INCENTIVE_PROGRAMS_FOR_USERS_STAKING_YIELD_FARMING_AIRDROPS_NFTS_ETC.getValue()),
                CategoriesType.LAUNCHING_A_DAO_WEB3.getValue(), Arrays.asList(LaunchingDaoWeb3ValueType.DAO_LEGAL_WRAPPER_SETUP.getValue(),
                        LaunchingDaoWeb3ValueType.DAO_GOVERNANCE_LEGAL_SETUP.getValue(),
                        LaunchingDaoWeb3ValueType.APPOINTMENT_OF_DAO_MANAGEMENT.getValue(),
                        LaunchingDaoWeb3ValueType.ONBOARDING_DAO_MEMBERS.getValue()));
        int i = 0;
        int j = 0;
        boolean sectionIsRight = false;
        for (Map.Entry<String, Collection<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();
            sectionsAndOptionsArray.putAll(key, value);
            for (String valueCurrent : value) {
                if (valueCurrent.equals(chosenOption)) {
                    i++;
                    if (key.equals(chosenSection)) {
                        j++;
                    }
                }
            }
        }
        if ((i == 1) && (j == 1)) {
            sectionIsRight = true;
        }
        return sectionIsRight;
    }


*/
}
