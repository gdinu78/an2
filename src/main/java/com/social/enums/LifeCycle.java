package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<String> getAllTypes(){
        return Arrays.stream(LifeCycle.class.getEnumConstants()).map(LifeCycle::getType).collect(Collectors.toList());
    }
}
