package pl.edu.wat.backend.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wat.backend.jpa.InvitationEntity;
import pl.edu.wat.backend.jpa.UserEntity;

import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Meeting {
    private int id;
    private String name;
    private Date date;
    private String description;
    private String place;
    Set<InvitationEntity> usersInvited;
    private UserEntity organizer;
}
