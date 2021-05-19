package pl.edu.wat.backend.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wat.backend.jpa.MeetingEntity;
import pl.edu.wat.backend.jpa.StatusEnum;
import pl.edu.wat.backend.jpa.UserEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Invitation {
    private int id;
    private StatusEnum status;
    private UserEntity userInvited;
    private MeetingEntity meeting;
}
