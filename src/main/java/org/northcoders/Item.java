package org.northcoders;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Item {
    private static int itemCount = 0; // Static counter for item IDs
    private int itemId; // Unique ID for the item
    private int owner;
    private String name;
    private int price;
    private String description;
    private LocalDateTime dateListed;

    // Constructor
    public Item(int owner, String name, int price, String description) {
        this.itemId = ++itemCount; // Increment and set itemId
        this.owner = owner;
        this.name = name;
        this.price = price;
        this.description = description;
        this.dateListed = LocalDateTime.now();
    }

    // Getters
    public int getItemId() {
        return itemId;
    }

    public int getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateListed() {
        return dateListed;
    }

    // Setters
    public void setOwner(String owner) {
        this.owner = Integer.parseInt(owner);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateListed(LocalDateTime dateListed) {
        this.dateListed = dateListed;
    }

    // Method to get a human-readable representation of the date listed
    public String getPrettyDateListed() {
        long minutes = ChronoUnit.MINUTES.between(dateListed, LocalDateTime.now());
        long hours = ChronoUnit.HOURS.between(dateListed, LocalDateTime.now());
        long days = ChronoUnit.DAYS.between(dateListed, LocalDateTime.now());

        if (minutes < 1) {
            return "listed just now";
        } else if (minutes < 60) {
            return minutes + " minute" + (minutes > 1 ? "s" : "") + " ago";
        } else if (hours < 24) {
            return hours + " hour" + (hours > 1 ? "s" : "") + " ago";
        } else {
            return days + " day" + (days > 1 ? "s" : "") + " ago";
        }
    }
}
