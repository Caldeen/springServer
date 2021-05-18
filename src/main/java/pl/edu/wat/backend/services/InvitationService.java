package pl.edu.wat.backend.services;


import pl.edu.wat.backend.api.Invitation;
import pl.edu.wat.backend.jpa.InvitationEntity;

import java.util.Set;

public interface InvitationService {
    void add(Invitation invitation);
    void delete(int invitationId);
    Set<Invitation> getAllInvitations();
}
