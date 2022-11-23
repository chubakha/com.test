package com.test;

public enum RegistrationParametersType {
    NESTOR("nestor"),
    DARIA("daria"),
    PRIVACY("privacy");

    private final String value;

    RegistrationParametersType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}