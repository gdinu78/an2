package com.social.enums;

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

    public String getType() {
        return type;
    }

}
