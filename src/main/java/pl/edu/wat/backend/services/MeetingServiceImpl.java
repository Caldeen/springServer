package pl.edu.wat.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.backend.api.Meeting;
import pl.edu.wat.backend.jpa.MeetingEntity;
import pl.edu.wat.backend.repositories.MeetingRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingRepository repository;
    @Override
    public void add(Meeting meeting) {
        MeetingEntity entity = MeetingEntity.builder()
                .id(meeting.getId())
                .name(meeting.getName())
                .date(meeting.getDate())
                .build();
    }

    @Override
    public void delete(int meetingId) {
        repository.deleteById(meetingId);
    }

    @Override
    public List<Meeting> getAllMeetings() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(meetingEntity -> new Meeting(meetingEntity.getId(),
                        meetingEntity.getName(), meetingEntity.getDate(),meetingEntity.getDescription(),
                        meetingEntity.getPlace(), meetingEntity.getUsersInvited(),
                        meetingEntity.getOrganizer()))
                .collect(Collectors.toList());
    }
}
