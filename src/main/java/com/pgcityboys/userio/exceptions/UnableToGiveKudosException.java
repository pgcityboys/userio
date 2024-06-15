package com.pgcityboys.userio.exceptions;

import java.time.LocalDateTime;

public class UnableToGiveKudosException extends Exception {

	public UnableToGiveKudosException(LocalDateTime date) {
		super("You have to wait until " + date.toString() + " to give another kudos");
	}

}
