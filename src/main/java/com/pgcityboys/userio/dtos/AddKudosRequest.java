package com.pgcityboys.userio.dtos;

import com.pgcityboys.userio.entities.User;

public record AddKudosRequest(User receiver, User sender, int points) {
}
