package com.social.enums;

public enum Permission {
    ADMIN("Admin"),
    USER("User"),
    GOLD("Gold");

    private String type;

    Permission(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
