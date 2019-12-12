package com.shenxiangwei.springbootjwttoken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={"com.shenxiangwei.*"})
public class SpringBootJwtTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtTokenApplication.class, args);
	}

}
