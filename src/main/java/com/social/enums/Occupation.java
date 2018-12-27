package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Occupation {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Occupation(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
