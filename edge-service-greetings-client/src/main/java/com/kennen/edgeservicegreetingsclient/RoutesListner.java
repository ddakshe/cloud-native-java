package com.kennen.edgeservicegreetingsclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RoutesListner {

    private final RouteLocator routeLocator;

    private final DiscoveryClient discoveryClient;

    private Log log = LogFactory.getLog(getClass());

    @Autowired
    public RoutesListner(DiscoveryClient discoveryClient, RouteLocator routeLocator){
        this.routeLocator = routeLocator;
        this.discoveryClient = discoveryClient;
    }

    @EventListener(HeartbeatEvent.class)
    public void onHeartbeatEvent(HeartbeatEvent event){
        this.log.info("onHeartbeatEvent()");
        this.discoveryClient.getServices().stream().map(x -> " " + x).forEach(this.log::info);
    }

    @EventListener
    public void onRoutesRefreshedEvent(RoutesRefreshedEvent routesRefreshedEvent){
        this.log.info("onRoutesRefreshedEvent");
        this.routeLocator.getRoutes().stream().map(x -> " " + x).forEach(this.log::info);
    }

}
