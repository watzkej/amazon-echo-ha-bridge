package com.armzilla.ha.api;

/**
 * Created by arm on 4/21/15.
 */
public class HAGateway {
    private String name;
    private String type;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
