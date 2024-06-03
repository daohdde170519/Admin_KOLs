package com.Admin.DemoAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.Admin.DemoAdmin"})
public class DemoAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAdminApplication.class, args);
	}

}
