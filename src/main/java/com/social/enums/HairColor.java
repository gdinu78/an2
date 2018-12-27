package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HairColor {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    HairColor(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
