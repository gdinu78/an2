package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Ethnicity {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Ethnicity(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
