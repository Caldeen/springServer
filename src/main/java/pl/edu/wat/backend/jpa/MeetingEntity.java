package pl.edu.wat.backend.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class MeetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private LocalDateTime date;
    private String description;
    private String place;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "meeting")
    Set<InvitationEntity> usersInvited ;
    @ManyToOne()
    private UserEntity organizer;
}
