package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Lifestyle {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Lifestyle(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
