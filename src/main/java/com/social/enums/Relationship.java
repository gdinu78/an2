package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Relationship {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Relationship(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
