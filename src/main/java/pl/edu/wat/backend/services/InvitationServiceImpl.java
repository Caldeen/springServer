package pl.edu.wat.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.backend.api.Invitation;
import pl.edu.wat.backend.jpa.InvitationEntity;
import pl.edu.wat.backend.repositories.InvitationRepository;

import java.util.Set;

@Service
public class InvitationServiceImpl implements InvitationService{
    @Autowired
    private InvitationRepository repository;
    @Override
    public void add(Invitation invitation) {
        InvitationEntity invitationEntity1 = InvitationEntity.builder()
                .id(invitation.getId())
                .build();
        repository.save(invitationEntity1);
    }

    @Override
    public void delete(int invitationId) {
        repository.deleteById(invitationId);
    }

    @Override
    public Set<Invitation> getAllInvitations() {
        return null;
    }
}
