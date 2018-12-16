package com.social.enums;

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

    public String getPath() {
        return path;
    }
}
