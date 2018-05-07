package com.thiagojavabr.servicecustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCustomerApplication.class, args);
	}
}

@RestController
class CustomerController {

	@Autowired
	private DiscoveryClient discoveryClient;


	@GetMapping("customer")
	String getCustomerMessage(){
		RestTemplate rest = new RestTemplate();
		String uri = discoveryClient.getInstances("service-product").get(0).getUri() + "/product";
		System.out.println("Service URI: " + uri);
		String resp = rest.getForObject(uri, String.class);
		System.out.println(resp);
		return "Customer can buy these products:\n" + resp;
	}
}

