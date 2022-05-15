package com.test.registration.first_registration_page;

public enum PrivacygdprcomplianceValueType {
    MAKE_THE_WEBSITE_APP_COMPLIANT_WITH_PRIVACY_LAWS("Make the website / app compliant with privacy laws"),
    START_WORKING_WITH_EU_BASED_CLIENTS_AND_USERS("Start working with EU-based clients and users"),
    SIGN_B2B_AGREEMENTS_WITH_EU_BASED_CLIENTS("Sign B2B agreements with EU-based clients");

    private String value;

    PrivacygdprcomplianceValueType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
