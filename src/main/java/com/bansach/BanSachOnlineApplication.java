package com.bansach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.bansach.BanSachOnlineApplication;

@SpringBootApplication
public class BanSachOnlineApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BanSachOnlineApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(BanSachOnlineApplication.class, args);
	}

}
