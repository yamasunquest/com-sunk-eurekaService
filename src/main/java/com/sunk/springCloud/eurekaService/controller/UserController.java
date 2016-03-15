package com.sunk.springCloud.eurekaService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
    @Autowired
    DiscoveryClient client;
    
	@RequestMapping("/name")
	public String getName(){
		return "sunkai";
	}
	
	@RequestMapping("/age")
	public int getAge(){
		return 10;
	}
	
	@RequestMapping("/hello")
	public String hello(){
		ServiceInstance localInstance = client.getLocalServiceInstance();
        return "Hello World: "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
	}
	
	@RequestMapping("/sleep/{time}")
	public String sleep(@PathVariable("time") Long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "user thread sleep:" + time;
	}
}