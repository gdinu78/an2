package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Education {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Education(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
