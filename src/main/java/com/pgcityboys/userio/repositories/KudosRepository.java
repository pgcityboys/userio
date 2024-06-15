package com.pgcityboys.userio.repositories;

import com.pgcityboys.userio.entities.Kudos;
import com.pgcityboys.userio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KudosRepository extends JpaRepository<Kudos, Long> {

	Optional<Kudos> findTopByOrderByTimeOfGrantingDesc();

	List<Kudos> findKudosByReceiver(User receiver);

}
