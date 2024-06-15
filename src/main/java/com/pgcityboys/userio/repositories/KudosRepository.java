package com.pgcityboys.userio.repositories;

import com.pgcityboys.userio.entities.Kudos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KudosRepository extends JpaRepository<Kudos, Long> {
}
