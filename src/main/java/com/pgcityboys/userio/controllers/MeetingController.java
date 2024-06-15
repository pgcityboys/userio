package com.pgcityboys.userio.controllers;

import com.pgcityboys.userio.dtos.AddKudosRequest;
import com.pgcityboys.userio.dtos.CreateMeetingRequest;
import com.pgcityboys.userio.dtos.CreateUserRequest;
import com.pgcityboys.userio.entities.Meeting;
import com.pgcityboys.userio.entities.User;
import com.pgcityboys.userio.exceptions.UnableToGiveKudosException;
import com.pgcityboys.userio.exceptions.UserDoesntExist;
import com.pgcityboys.userio.exceptions.UsernameTakenException;
import com.pgcityboys.userio.services.MeetingService;
import com.pgcityboys.userio.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.pgcityboys.userio.UserioApplication.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/meetings")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping()
    public ResponseEntity<?> createMeeting(@RequestBody CreateMeetingRequest createMeetingRequest) {
        Meeting createdMeeting = meetingService.createMeeting(createMeetingRequest);
        return new ResponseEntity<>(createdMeeting, HttpStatus.CREATED);
    }

    @GetMapping("/{category}")
    public List<Meeting> getMeetingsByCategory(@PathVariable String category) {
        return meetingService.getMeetingsByCategory(category);
    }
}