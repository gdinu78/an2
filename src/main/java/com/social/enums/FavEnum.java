package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FavEnum {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    FavEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
