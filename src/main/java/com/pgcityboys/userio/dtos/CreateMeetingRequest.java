package com.pgcityboys.userio.dtos;

public record CreateMeetingRequest(String startTime, String endTime, String category, String link, int day, int month, int year) {
}
