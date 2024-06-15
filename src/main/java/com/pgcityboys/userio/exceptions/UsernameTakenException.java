package com.pgcityboys.userio.exceptions;

public class UsernameTakenException extends Exception {

	public UsernameTakenException(String login) {
		super("User with login: " + login + " already exists");
	}

}
