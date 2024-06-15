package com.pgcityboys.userio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserioApplication {

	public static final String API_VERSION = "v1";
	public static final String BASE_URL = "/api/" + API_VERSION;

	public static void main(String[] args) {
		SpringApplication.run(UserioApplication.class, args);
	}

}
