package com.armzilla.ha.api.wink;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by John on 5/2/2015.
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.WRAPPER_OBJECT, property="modelName")
@JsonSubTypes({ @JsonSubTypes.Type(value = WinkAnalogSwitch.class, name = "Dimmer"), @JsonSubTypes.Type(value = WinkBinarySwitch.class, name = "Switch") })
public abstract class WinkDevice {

    private String modelName;
    private String name;
    private String id;

    public String getModelName() { return modelName; }

    public void setModelName(String modelName) { this.modelName = modelName; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public abstract String getId();

    public abstract void setId(String id);

}
