package com.test.registration;

public enum HiringValueType {
    HIRE_A_NEW_TEAM_MEMBER("Hire a new team member "),
    PROTECT_INTELLECTUAL_PROPERTY_AND_TRADE_SECRETS("Protect intellectual property and trade secrets"),
    INCENTIVIZE_THE_TEAM_BY_ISSUING_SHARE_OPTIONS("Incentivize the team by issuing share options"),
    ENGAGE_A_NEW_CONTRACTOR("Engage a new contractor ");

    private String value;

    HiringValueType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
