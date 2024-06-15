package com.pgcityboys.userio.exceptions;

public class UserDoesntExist extends Exception {

	public UserDoesntExist(Long id) {
		super("User with id " + id + " doesnt exist");
	}

}
