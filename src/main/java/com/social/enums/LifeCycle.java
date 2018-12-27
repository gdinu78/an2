package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LifeCycle {
    CREATED("Created"),
    APPROVED("Approved"),
    SILVER("Silver"),
    GOLD("Gold"),
    DELETED("Deleted");

    private String type;

    LifeCycle(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

}
