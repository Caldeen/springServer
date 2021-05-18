package pl.edu.wat.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.backend.services.MeetingService;

import java.util.List;

@RestController
public class MeetingController {
    @Autowired
     private MeetingService service;

    @GetMapping("/spotkania")
    public ResponseEntity<List<Meeting>> getAllMeetings() {
        List<Meeting>  meetings= service.getAllMeetings();
        return new ResponseEntity<>(meetings, HttpStatus.OK);
    }

}
