package api.themes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ThemeRepository extends CrudRepository<Theme, Long> {
    @Query(value="SELECT id FROM Theme WHERE id = (SELECT MAX(id) FROM Theme)")
    Long findHighestId();
}