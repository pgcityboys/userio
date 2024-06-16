package com.pgcityboys.userio.repositories;

import com.pgcityboys.userio.entities.Kudos;
import com.pgcityboys.userio.entities.Meeting;
import com.pgcityboys.userio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findAllByCategory(String category);
}