package com.test.registration.depreciated.first_registration_page;

public enum TokenGenerationDistributionValueType {
    REGISTER_A_COMPANY_TO_ISSUE_THE_TOKENS("Register a company to issue the tokens"),
    ENSURING_REGULATORY_AND_AML_COMPLIANCE_WHEN_SELLING_TOKENS("Ensuring regulatory and AML compliance when selling tokens"),
    PUBLIC_TOKEN_DISTRIBUTION_THROUGH_LAUNCHPADS_LISTING_TOKENS_ON_CRYPTO_EXCHANGES("Public Token distribution through launchpads, listing tokens on crypto exchanges"),
    LAUNCHING_DEFI_AND_TOKEN_INCENTIVE_PROGRAMS_FOR_USERS_STAKING_YIELD_FARMING_AIRDROPS_NFTS_ETC("Launching DeFi and token incentive programs for users (staking, yield farming, airdrops, NFTs, etc.)");

    private String value;

    TokenGenerationDistributionValueType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
