package com.pgcityboys.userio.controllers;

import com.pgcityboys.userio.dtos.AddKudosRequest;
import com.pgcityboys.userio.dtos.CreateUserRequest;
import com.pgcityboys.userio.entities.User;
import com.pgcityboys.userio.exceptions.UnableToGiveKudosException;
import com.pgcityboys.userio.exceptions.UserDoesntExist;
import com.pgcityboys.userio.exceptions.UsernameTakenException;
import com.pgcityboys.userio.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.pgcityboys.userio.UserioApplication.BASE_URL;

@CrossOrigin(originPatterns = "*" )
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

	@GetMapping("/{login}")
	public ResponseEntity<?> getUser(@PathVariable String login) {
		try {
			User foundUser = userService.getUser(login);
			return new ResponseEntity<>(foundUser, HttpStatus.OK);
		}
		catch (UserDoesntExist e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/kudos")
	public ResponseEntity<?> addPoints(@RequestBody AddKudosRequest addKudosRequest) {
		try {
			userService.addKudos(addKudosRequest);
			String message = String.format("%s sent to %s %d points", addKudosRequest.sender().toString(),
					addKudosRequest.receiver().toString(), addKudosRequest.points());
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (UnableToGiveKudosException | UserDoesntExist e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/kudos/{id}")
	public ResponseEntity<?> getUsersKudos(@PathVariable Long id) {
		try {
			int kudosPoints = userService.getUsersKudos(id);
			return new ResponseEntity<>(kudosPoints, HttpStatus.OK);
		} catch (UserDoesntExist e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

}
