package com.pgcityboys.userio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Kudos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private User receiver;
	@ManyToOne
	private User sender;
	private int points;
	private LocalDateTime timeOfGranting;

	public Kudos(User receiver, User sender, int points) {
		this.receiver = receiver;
		this.sender = sender;
		this.points = points;
		timeOfGranting = LocalDateTime.now();
	}

}
