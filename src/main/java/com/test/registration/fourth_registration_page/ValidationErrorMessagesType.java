package com.test.registration.fourth_registration_page;

public enum ValidationErrorMessagesType {
    FIELD_IS_REQUIRED("field is required"),
    PASSWORDS_MISMATCH("Passwords mismatch"),
    MIN_LENGTH_IS_8_SYMBOLS("min length is 8 symbols (%s)"),
    MAX_LENGTH_IS_14_SYMBOLS("max length is 14 symbols (%s)");

    private String value;

    ValidationErrorMessagesType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}