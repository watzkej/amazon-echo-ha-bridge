package com.armzilla.ha.gateway;

import com.armzilla.ha.api.HADevice;
import com.armzilla.ha.api.wink.WinkDataResponse;
import com.armzilla.ha.api.wink.WinkDevice;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by John on 5/2/2015.
 */
public class WinkGatewayImpl {
    private String address;
    protected RestTemplate restTemplate = new RestTemplate();

    public WinkGatewayImpl(String address){
        this.address = address;
    }

    public List<HADevice> getAllDevices() throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder();
        URI uri = uriBuilder.setHost(address).setPort(3480).setScheme("http").setPath("/data_request")
                .addParameter("id", "sdata").addParameter("format", "json").build();
        WinkDataResponse response = restTemplate.getForObject(uri, WinkDataResponse.class);
        List<HADevice> deviceList = new LinkedList<>();
        if(response != null && response.getDevices() !=  null) {
            for (WinkDevice device : response.getDevices()) {
                String modelName = device.getModelName();
                String categoryName;
                switch(modelName){
                    case "Dimmer":
                        categoryName = "Analog Switch";
                        break;
                    case "Switch":
                        categoryName = "Binary Switch";
                        break;
                    default:
                        continue; /* filter out non switch */
                } /* total lazy */

                HADevice haDevice = new HADevice();
                haDevice.setDeviceType(categoryName);
                haDevice.setExternalId(device.getId());
                haDevice.setName(device.getName());
                deviceList.add(haDevice);
            }
        }
        return deviceList;
    }
}
