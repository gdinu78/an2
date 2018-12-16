package com.social.enums;

public enum RolEnum {
    ADMIN("Admin"),
    USER("User"),
    SUPPLIER("Supplier");

    private String type;

    RolEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
