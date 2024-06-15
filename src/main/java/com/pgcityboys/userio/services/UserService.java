package com.pgcityboys.userio.services;

import com.pgcityboys.userio.dtos.AddKudosRequest;
import com.pgcityboys.userio.dtos.CreateUserRequest;
import com.pgcityboys.userio.entities.Kudos;
import com.pgcityboys.userio.entities.User;
import com.pgcityboys.userio.exceptions.UnableToGiveKudosException;
import com.pgcityboys.userio.exceptions.UserDoesntExist;
import com.pgcityboys.userio.exceptions.UsernameTakenException;
import com.pgcityboys.userio.repositories.KudosRepository;
import com.pgcityboys.userio.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
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

	public void addKudos(AddKudosRequest addKudosRequest) throws UnableToGiveKudosException, UserDoesntExist {
		Optional<Kudos> kudos = kudosRepository.findTopByOrderByTimeOfGrantingDesc();
		if (kudos.isPresent()) {
			Duration d = Duration.between(kudos.get().getTimeOfGranting(), LocalDateTime.now());
			if (d.toHours() <= 24) {
				throw new UnableToGiveKudosException(kudos.get().getTimeOfGranting().plusHours(24));
			}
		}

		Optional<User> receiver = userRepository.findById(addKudosRequest.receiver());
		Optional<User> sender = userRepository.findById(addKudosRequest.sender());
		if (receiver.isEmpty() || sender.isEmpty()) {
			throw new UserDoesntExist(addKudosRequest.receiver(), addKudosRequest.sender());
		}

		Kudos newKudos = new Kudos(receiver.get(), sender.get(), addKudosRequest.points());
		kudosRepository.save(newKudos);
	}

	public int getUsersKudos(Long id) throws UserDoesntExist {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserDoesntExist(id);
		}

		List<Kudos> userKudos = kudosRepository.findKudosByReceiver(user.get());
		int kudosPoints = 0;
		for (Kudos k: userKudos) {
			kudosPoints += k.getPoints();
		}

		return kudosPoints;
	}

}
