package pl.edu.wat.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.backend.services.MeetingService;
import pl.edu.wat.backend.services.UserService;

import java.util.List;
import java.util.UUID;

@RestController
public class MeetingController {
    @Autowired
     private MeetingService service;



    @GetMapping("/meetings")
    public ResponseEntity<List<MeetingResponse>> getUsersMeetings(@RequestHeader("SESSION") UUID token) {
        List<MeetingResponse>  meetings= service.getUsersMeetings(token);
        return new ResponseEntity<>(meetings, HttpStatus.OK);
    }@PostMapping("/addMeeting")
    public ResponseEntity<String> addMeeting(@RequestHeader("SESSION") UUID token,
                                             @RequestBody MeetingResponse meetingResponse) {
        service.add(meetingResponse,token);
        return new ResponseEntity<>("added", HttpStatus.OK);
    }
    @DeleteMapping("/delete-meeting/{meetingId}")
    public ResponseEntity<String> deleteMeeting(@RequestHeader("SESSION") UUID token,
                                                @PathVariable("meetingId") int meetingId) {

        service.delete(meetingId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
