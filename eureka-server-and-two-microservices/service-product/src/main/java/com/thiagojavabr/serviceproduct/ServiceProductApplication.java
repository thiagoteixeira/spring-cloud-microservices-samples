package com.thiagojavabr.serviceproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProductApplication.class, args);
	}
}

@RestResource(path = "product", rel = "product")
@Repository
interface ProductRepository extends JpaRepository<Product, Long> {
}

@Entity
class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

