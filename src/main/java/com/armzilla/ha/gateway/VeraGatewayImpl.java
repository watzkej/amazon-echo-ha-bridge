package com.armzilla.ha.gateway;

import com.armzilla.ha.api.HADevice;
import com.armzilla.ha.api.vera.VeraDataResponse;
import com.armzilla.ha.api.vera.VeraDevice;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arm on 4/27/15.
 */
public class VeraGatewayImpl {
    private String address;
    protected RestTemplate restTemplate = new RestTemplate();

    public VeraGatewayImpl(String address){
        this.address = address;
    }

    public List<HADevice> getAllDevices() throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder();
        URI uri = uriBuilder.setHost(address).setPort(3480).setScheme("http").setPath("/data_request")
                .addParameter("id", "sdata").addParameter("format", "json").build();
        VeraDataResponse response = restTemplate.getForObject(uri, VeraDataResponse.class);
        List<HADevice> deviceList = new LinkedList<>();
        if(response != null && response.getDevices() !=  null) {
            for (VeraDevice device : response.getDevices()) {
                int category = device.getCategory();
                String categoryName;
                switch(category){
                    case 2:
                        categoryName = "Analog Switch";
                        break;
                    case 3:
                        categoryName = "Binary Switch";
                        break;
                    default:
                        continue; /* filter out non switch */
                } /* total lazy */
                //TODO: add scenes here
                HADevice haDevice = new HADevice();
                haDevice.setDeviceType(categoryName);
                haDevice.setExternalId(Integer.toString(device.getId()));
                haDevice.setName(device.getName());
                deviceList.add(haDevice);
            }
        }
        return deviceList;
    }
}
