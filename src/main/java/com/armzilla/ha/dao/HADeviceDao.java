package com.armzilla.ha.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Parent;

/**
 * Created by arm on 4/21/15.
 */
@Document(indexName = "device", type = "device", shards = 1, replicas = 0, refreshInterval = "-1")
public class HADeviceDao {

    @Id
    private String id;
    @Parent(type = "HAGatewayDao")
    private String parentId;
    private String name;
    private String deviceType;
    private String externalId;

    public String getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
