package com.armzilla.ha.api.wink;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by John on 5/3/2015.
 */
public class WinkAnalogSwitch extends WinkDevice {

    @JsonProperty("light_bulb_id")
    public String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
