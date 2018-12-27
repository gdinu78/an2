package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Income {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Income(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
