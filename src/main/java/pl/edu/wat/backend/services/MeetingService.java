package pl.edu.wat.backend.services;

import pl.edu.wat.backend.api.Meeting;
import pl.edu.wat.backend.api.MeetingResponse;

import java.util.List;
import java.util.UUID;

public interface MeetingService {
    void add(Meeting meeting);
    void delete(int meetingId);
    List<Meeting> getAllMeetings();

    List<MeetingResponse> getUsersMeetings(UUID token);
}
