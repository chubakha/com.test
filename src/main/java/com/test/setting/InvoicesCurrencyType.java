package com.test.setting;

public enum InvoicesCurrencyType {
    USD("USD"),
    EUR("EUR"),
    GBP("GBP"),
    Tether("Tether TRC20"),
    NEAR("NEAR");

    private String value;

    InvoicesCurrencyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
