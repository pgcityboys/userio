package com.pgcityboys.userio.exceptions;

public class UserDoesntExist extends Exception {

	public UserDoesntExist(Long id) {
		super("User with id " + id + " doesnt exist");
	}
	public UserDoesntExist(Long id1, Long id2) {
		super("User with id " + id1 + " or " + id2 + " doesnt exist");
	}

}
