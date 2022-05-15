package com.test.registration.first_registration_page;

public enum IpprotectionValueType {
    PROTECT_THE_NAME_AND_LOGO_OF_THE_COMPANY("Protect the name and logo of the company"),
    PROTECT_THE_COMPANYS_INVENTION("Protect the company`s invention");

    private String value;

    IpprotectionValueType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
