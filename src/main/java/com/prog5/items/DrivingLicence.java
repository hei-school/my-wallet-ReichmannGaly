package com.prog5.items;

public class DrivingLicence {
    public enum Category {
        A, B , C, D, E
    }
    private String owner;

    private Category category;

    public DrivingLicence(String owner, Category category) {
        this.owner = owner;
        this.category = category;
    }

    @Override
    public String toString() {
        return "\nDrivingLicence: " +
                "\nowner: " + owner +
                ", category: " + category;
    }
}
