package com.pgcityboys.userio.services;

import com.pgcityboys.userio.dtos.AddKudosRequest;
import com.pgcityboys.userio.dtos.CreateMeetingRequest;
import com.pgcityboys.userio.dtos.CreateUserRequest;
import com.pgcityboys.userio.entities.Kudos;
import com.pgcityboys.userio.entities.Meeting;
import com.pgcityboys.userio.entities.User;
import com.pgcityboys.userio.exceptions.UnableToGiveKudosException;
import com.pgcityboys.userio.exceptions.UserDoesntExist;
import com.pgcityboys.userio.exceptions.UsernameTakenException;
import com.pgcityboys.userio.repositories.KudosRepository;
import com.pgcityboys.userio.repositories.MeetingRepository;
import com.pgcityboys.userio.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public Meeting createMeeting(CreateMeetingRequest createMeetingRequest) {
        Meeting newMeeting = new Meeting(createMeetingRequest);
        return meetingRepository.save(newMeeting);
    }

    public List<Meeting> getMeetingsByCategory(String category){
        if(category.equals("any")){
            return meetingRepository.findAll();
        }
        return meetingRepository.findAllByCategory(category);
    }

}
