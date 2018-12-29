package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RolEnum {
    ADMIN("Admin"),
    USER("User"),
    SILVER("Silver"),
    GOLD("Gold");

    private String type;

    RolEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
