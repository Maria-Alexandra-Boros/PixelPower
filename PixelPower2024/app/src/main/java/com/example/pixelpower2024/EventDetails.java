package com.example.pixelpower2024;

import java.io.Serializable;

public class EventDetails implements Serializable {
    private String name;
    private int imageResourceId;
    private String date;
    private String price;
    private String description;

    public EventDetails(String name, int imageResourceId, String date, String price, String description) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.date = date;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
