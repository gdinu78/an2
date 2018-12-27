package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Permission {
    ADMIN("Admin"),
    USER("User"),
    GOLD("Gold");

    private String type;

    Permission(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
