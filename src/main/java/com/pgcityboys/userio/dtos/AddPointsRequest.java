package com.pgcityboys.userio.dtos;

import com.pgcityboys.userio.entities.User;

public record AddPointsRequest(User receiver, User transferring, int points) {
}
