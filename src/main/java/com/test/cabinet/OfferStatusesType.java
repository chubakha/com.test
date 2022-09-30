package com.test.cabinet;

public enum OfferStatusesType {
    DISCUSS_WITH_VLO("DISCUSS WITH VLO");

    private final String value;

    OfferStatusesType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
