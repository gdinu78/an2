package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LifeCycle {
    WAITING_APPROVAL("Waiting_approval"),
    APPROVED("Approved"),
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
