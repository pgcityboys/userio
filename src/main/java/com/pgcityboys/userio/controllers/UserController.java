package com.pgcityboys.userio.controllers;

import com.pgcityboys.userio.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.pgcityboys.userio.UserioApplication.BASE_URL;

@RequestMapping(BASE_URL + "/users")
public class UserController {

	@PostMapping
	public User createUser() {
		return null;
	}

	@GetMapping("/{login}")
	public User getUser() {
		return null;
	}

	@PostMapping("/kudos")
	public void addPoints() {

	}

}
