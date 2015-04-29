package com.armzilla.ha.api.vera;

/**
 * Created by arm on 4/27/15.
 */
public class VeraDevice {
    private String name;
    private int id;
    private int category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
