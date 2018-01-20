package com.ny.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class DiscoveryCtrl {

    private EurekaClient eurekaClient;

    private DiscoveryClient discoveryClient;

    public DiscoveryCtrl(EurekaClient eurekaClient, DiscoveryClient discoveryClient) {
        this.eurekaClient = eurekaClient;
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping(value = "/erk/info", method = RequestMethod.GET)
    public String erkInfo() {
        List<InstanceInfo> instanceInfo = eurekaClient.getInstancesByVipAddress("PARADISE", false);
        StringBuilder ret = new StringBuilder();
        for (InstanceInfo info : instanceInfo) {
            ret.append(info.getHomePageUrl()).append(" ");
        }
        return ret.toString();
    }

    @RequestMapping(value = "/discovery/info", method = RequestMethod.GET)
    public String discoveryInfo() {
        List<ServiceInstance> services = discoveryClient.getInstances("PARADISE");
        StringBuilder ret = new StringBuilder();
        for (ServiceInstance service : services) {
            ret.append(service.getHost())
                    .append(":")
                    .append(service.getPort())
                    .append(" ");
        }
        return ret.toString();
    }

}
