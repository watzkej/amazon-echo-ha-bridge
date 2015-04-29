package com.armzilla.ha.api.vera;

import java.util.List;

/**
 * Created by arm on 4/27/15.
 */
public class VeraDataResponse {

    private String model;
    private String serial_number;
    private List<VeraDevice> devices;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public List<VeraDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<VeraDevice> devices) {
        this.devices = devices;
    }
}
