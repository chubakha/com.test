package com.test.registration.depreciated.first_registration_page;

public enum CategoriesType {
    INCORPORATION("INCORPORATION"),
    ACCOUNTING_TAXES("ACCOUNTING & TAXES"),
    HIRING("HIRING"),
    IP_PROTECTION("IP PROTECTION"),
    CLIENT_ACQUISITION("CLIENT ACQUISITION"),
    PRIVACY_GDPR_COMPLIANCE("PRIVACY & GDPR COMPLIANCE"),
    FUNDRAISING("FUNDRAISING"),
    TOKEN_GENERATION_DISTRIBUTION_WEB3("TOKEN GENERATION DISTRIBUTION WEB3"),
    LAUNCHING_A_DAO_WEB3("LAUNCHING A DAO WEB3");

    private String value;

    CategoriesType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
