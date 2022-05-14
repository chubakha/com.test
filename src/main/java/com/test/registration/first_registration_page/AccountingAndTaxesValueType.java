package com.test.registration.first_registration_page;

public enum AccountingAndTaxesValueType {
    GET_TAXATION_ANALYSIS_ON_THE_COUNTRY_CHOSEN_FOR_COMPANY_REGISTRATION("Get taxation analysis on the country chosen for company registration"),
    OBTAIN_A_COMPANY_TAX_NUMBER("Obtain a company tax number"),
    START_ISSUING_AND_COLLECTING_INVOICES_IN_A_TAX_COMPLIANT_WAY("Start issuing and collecting invoices in a tax-compliant way"),
    SET_UP_ACCOUNTING_FOR_PAYING_SALARIES("Set up accounting for paying salaries"),
    OBTAIN_COMPANY_VAT_NUMBER("Obtain company VAT number");

    private String value;

    AccountingAndTaxesValueType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
