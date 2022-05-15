package com.test.registration.first_registration_page;

public enum ClientAcquisitionValueType {
    START_USER_ACQUISITION_ON_THE_WEBSITE_APP("Start user acquisition on the website / app"),
    START_RECEIVING_PAYMENTS_FROM_B2B_CLIENTS("Start receiving payments from B2B clients"),
    START_WORKING_WITH_A_NEW_REFERRAL_PARTNER("Start working with a new referral partner");

    private String value;

    ClientAcquisitionValueType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
