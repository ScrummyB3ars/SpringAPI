package api.interaction_types;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Interaction_typeRepository extends CrudRepository<Interaction_type, Long> {
    @Query(value="SELECT id FROM Interaction_type WHERE id = (SELECT MAX(id) FROM Interaction_type )")
    Long findHighestId();
}