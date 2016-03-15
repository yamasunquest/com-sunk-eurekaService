package com.sunk.springCloud.eurekaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//注册到eureka
//在使用Eureka框架时，使用@EnableDiscoveryClient+eureka=@EnableEurekaClient
//在使用zookeeper框架时：使用@EnableDiscoveryClient
@EnableEurekaClient
public class EurekaServiceApp 
{
    public static void main( String[] args )
    {    	 
    	SpringApplication.run(EurekaServiceApp.class, args);
    }
}