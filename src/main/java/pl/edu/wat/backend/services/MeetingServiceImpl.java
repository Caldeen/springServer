package pl.edu.wat.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.backend.api.Meeting;
import pl.edu.wat.backend.api.MeetingResponse;
import pl.edu.wat.backend.api.User;
import pl.edu.wat.backend.jpa.MeetingEntity;
import pl.edu.wat.backend.repositories.MeetingRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingRepository repository;
    @Autowired
    private UserService userService;
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
         List<Meeting> list = StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(meetingEntity -> new Meeting(meetingEntity.getId(),
                        meetingEntity.getName(), meetingEntity.getDate(),meetingEntity.getDescription(),
                        meetingEntity.getPlace(), meetingEntity.getUsersInvited(),
                        meetingEntity.getOrganizer()))
                .collect(Collectors.toList());
       Collections.sort(list, Comparator.comparing(Meeting::getDate));
       Collections.reverse(list);
       return list;
    }

    @Override
    public List<MeetingResponse> getUsersMeetings(UUID token) {
        User user = userService.findUserByToken(token);
        return user.getMeetings().stream()
                .map(meetingEntity -> new MeetingResponse(meetingEntity.getId(),
                        meetingEntity.getName(), meetingEntity.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                        ,meetingEntity.getDescription(),
                        meetingEntity.getPlace()))
                .collect(Collectors.toList());
    }

    @Override
    public void add(MeetingResponse meetingResponse, UUID token) {
        System.out.println(meetingResponse.getDate());
        System.out.println("after " + LocalDateTime.parse(meetingResponse.getDate(),
                DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        MeetingEntity entity = MeetingEntity.builder()
                .date(LocalDateTime.parse(meetingResponse.getDate()))
                .name(meetingResponse.getName())
                .description(meetingResponse.getDescription())
                .place(meetingResponse.getPlace())
                .organizer(userService.findUserEntByToken(token))
                .build();
        repository.save(entity);
    }
}
