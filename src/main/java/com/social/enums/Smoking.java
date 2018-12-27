package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Smoking {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Smoking(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
