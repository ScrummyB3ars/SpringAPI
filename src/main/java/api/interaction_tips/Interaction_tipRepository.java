package api.interaction_tips;

import api.interaction_tips.Interaction_tip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Interaction_tipRepository extends CrudRepository<Interaction_tip, Long> {
    @Query(value="SELECT id FROM Interaction_tip WHERE id = (SELECT MAX(id) FROM Interaction_tip)")
    Long findHighestId();
}