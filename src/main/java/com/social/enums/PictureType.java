package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PictureType {
    IMAGES("/upload/images", ".jpg", ".bmp", ".gif", ".png", ".jpeg"),
    VIDEOS("/upload/videos", ".avi", ".mpeg", ".mpg", ".mp4", ".mov", ".mkv", ".flv"),
    MUSICS("/upload/musics", ".mp3", ".wav");

    private String path;
    private String[] formats;

    PictureType(String path, String... format) {
        this.path = path;
        this.formats = format;
    }

    public String[] getFormats() {
        return formats;
    }

    @JsonValue
    public String getPath() {
        return path;
    }

    public static List<String> getAllTypes(){
        return Arrays.stream(PictureType.class.getEnumConstants()).map(PictureType::getPath).collect(Collectors.toList());
    }
}
