package com.test.registration.first_registration_page;

public enum LaunchingDaoWeb3ValueType {
    DAO_LEGAL_WRAPPER_SETUP("DAO Legal Wrapper setup"),
    DAO_GOVERNANCE_LEGAL_SETUP("DAO Governance legal setup"),
    APPOINTMENT_OF_DAO_MANAGEMENT("Appointment of DAO Management"),
    ONBOARDING_DAO_MEMBERS("Onboarding DAO members");

    private String value;

    LaunchingDaoWeb3ValueType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
