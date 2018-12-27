package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BodyType {
    SLIM("Slim"),
    FAT("Fat"),
    AVERAGE("Average");

    private String type;

    BodyType(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
