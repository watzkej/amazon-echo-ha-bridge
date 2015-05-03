package com.armzilla.ha.api.wink;

import java.util.List;

/**
 * Created by John on 5/2/2015.
 */
public class WinkDataResponse {

    private List<WinkDevice> devices;

    public List<WinkDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<WinkDevice> devices) { this.devices = devices; }
}
