package pl.edu.wat.backend.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wat.backend.jpa.InvitationEntity;
import pl.edu.wat.backend.jpa.UserEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MeetingResponse {
    private int id;
    private String name;
    private String date;
    private String description;
    private String place;
}
