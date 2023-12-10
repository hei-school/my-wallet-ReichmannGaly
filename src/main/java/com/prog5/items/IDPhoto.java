package com.prog5.items;

public class IDPhoto {
    private String owner;

    public IDPhoto(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "\nIDPhoto: " +
                "\nowner: " + owner;
    }
}
