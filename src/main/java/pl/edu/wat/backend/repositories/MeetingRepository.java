package pl.edu.wat.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.backend.jpa.MeetingEntity;

@Repository
public interface MeetingRepository extends CrudRepository<MeetingEntity,Integer> {
}
