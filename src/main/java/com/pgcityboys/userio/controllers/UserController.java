package com.pgcityboys.userio.controllers;

import com.pgcityboys.userio.dtos.AddKudosRequest;
import com.pgcityboys.userio.dtos.CreateUserRequest;
import com.pgcityboys.userio.entities.User;
import com.pgcityboys.userio.exceptions.UserDoesntExist;
import com.pgcityboys.userio.exceptions.UsernameTakenException;
import com.pgcityboys.userio.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pgcityboys.userio.UserioApplication.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest) {
		try {
			User createdUser = userService.createUser(createUserRequest);
			return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		}
		catch (UsernameTakenException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		try {
			User foundUser = userService.getUser(id);
			return new ResponseEntity<>(foundUser, HttpStatus.OK);
		}
		catch (UserDoesntExist e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/kudos")
	public void addPoints(@RequestBody AddKudosRequest addKudosRequest) {

	}

}
