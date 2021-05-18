package pl.edu.wat.backend.services;

import pl.edu.wat.backend.api.Meeting;

import java.util.List;

public interface MeetingService {
    void add(Meeting meeting);
    void delete(int meetingId);
    List<Meeting> getAllMeetings();
}
