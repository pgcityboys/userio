package com.pgcityboys.userio.entities;

import com.pgcityboys.userio.dtos.CreateMeetingRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Table(name = "meetings")
@Entity
@NoArgsConstructor
@Getter
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startTime;
    private String endTime;
    private String category;
    private String link;
    private int day;
    private int month;
    private int year;

    public Meeting(CreateMeetingRequest createMeetingRequest) {
        this.startTime = createMeetingRequest.startTime();
        this.endTime = createMeetingRequest.endTime();
        this.category = createMeetingRequest.category();
        this.link = createMeetingRequest.link();
        this.day = createMeetingRequest.day();
        this.month = createMeetingRequest.month();
        this.year = createMeetingRequest.year();
    }
}