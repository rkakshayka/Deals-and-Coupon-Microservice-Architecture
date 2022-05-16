package com.couponservice.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@OpenAPIDefinition(info = @Info(
				       title = "Deals & Coupons API", 
				     version = "3.0", 
				 description = "Coupon Microservice Information"))
@SpringBootApplication
@EnableEurekaClient
public class CouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class, args);
    }
}
