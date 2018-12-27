package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Worth {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Worth(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
