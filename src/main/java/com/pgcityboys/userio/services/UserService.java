package com.pgcityboys.userio.services;

import com.pgcityboys.userio.dtos.AddKudosRequest;
import com.pgcityboys.userio.dtos.CreateUserRequest;
import com.pgcityboys.userio.entities.User;
import com.pgcityboys.userio.exceptions.UserDoesntExist;
import com.pgcityboys.userio.exceptions.UsernameTakenException;
import com.pgcityboys.userio.repositories.KudosRepository;
import com.pgcityboys.userio.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final KudosRepository kudosRepository;

	public User createUser(CreateUserRequest createUserRequest) throws UsernameTakenException {
		Optional<User> user = userRepository.findUserByLogin(createUserRequest.login());
		if (user.isPresent()) {
			throw new UsernameTakenException(createUserRequest.login());
		}

		User newUser = new User(createUserRequest.login());

		return userRepository.save(newUser);
	}

	public User getUser(Long id) throws UserDoesntExist {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserDoesntExist(id);
		}

		return user.get();
	}

	public void addKudos(AddKudosRequest addKudosRequest) {

	}

}
