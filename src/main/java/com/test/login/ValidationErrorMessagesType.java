package com.test.login;

public enum ValidationErrorMessagesType {
    MISSING_PARAMETERS("Missing parameters: \"username\" and \"password\" required"),
    INVALID_USERNAME_AND_PASSWORD_COMBINATION("Invalid username and password combination"),
    ENTER_CORRECT_EMAIL("ENTER CORRECT EMAIL"),
    FIELD_IS_REQUIRED("FIELD IS REQUIRED");

    private String value;

    ValidationErrorMessagesType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}