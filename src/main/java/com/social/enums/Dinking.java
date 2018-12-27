package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Dinking {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Dinking(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
