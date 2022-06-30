package com.test.registration.depreciated.first_registration_page;

public enum IncorporationValuesType {
    PICK_THE_BEST_JURISDICTIONS_AND_CORPORATE_STRUCTURE_FOR_MY_TECH_PROJECT("Pick the best jurisdictions and corporate structure for my tech project"),
    REGISTER_A_COMPANY_FOR_INITIAL_FUNDRAISING_AND_GO_TO_MARKET("Register a company for initial fundraising & go-to-market"),
    SET_UP_OR_UPDATE_TERMS_OF_COOPERATION_BETWEEN_FOUNDERS("Set up or update terms of cooperation between founders");

    private String value;

    IncorporationValuesType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}