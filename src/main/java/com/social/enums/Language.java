package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Language {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Language(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
