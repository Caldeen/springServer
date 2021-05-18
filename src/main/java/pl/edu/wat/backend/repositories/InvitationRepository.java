package pl.edu.wat.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wat.backend.jpa.InvitationEntity;


public interface InvitationRepository extends CrudRepository<InvitationEntity,Integer> {
}
