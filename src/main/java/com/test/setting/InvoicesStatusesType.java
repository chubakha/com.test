package com.test.setting;

public enum InvoicesStatusesType {
    UNPAID("Unpaid"),
    PAID("Paid"),
    CLOSED("Closed");

    private String value;

    InvoicesStatusesType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
