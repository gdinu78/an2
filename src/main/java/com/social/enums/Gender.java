package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");


    private String type;

    Gender(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    public static List<String> getAllTypes(){
        return Arrays.stream(Gender.class.getEnumConstants()).map(Gender::getType).collect(Collectors.toList());
    }
}
