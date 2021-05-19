package pl.edu.wat.backend.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class InvitationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;
    @ManyToOne
    private MeetingEntity meeting;
    @ManyToOne
    private UserEntity userInvited;

}
