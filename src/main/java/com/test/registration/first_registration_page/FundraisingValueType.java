package com.test.registration.first_registration_page;

public enum FundraisingValueType {
    PREPARE_FOR_THE_FUNDRAISING("Prepare for the fundraising"),
    RAISE_INVESTMENTS("Raise investments"),
    RAISE_INVESTMENTS_WITH_THE_PROMISE_TO_ISSUE_TOKENS("Raise investments with the promise to issue tokens"),
    MAKE_A_CASH_OUT_EXIT("Make a cash-out / exit");

    private String value;

    FundraisingValueType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
