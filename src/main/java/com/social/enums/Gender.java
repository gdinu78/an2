package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");


    private String type;

    Gender(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
