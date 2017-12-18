package api.theme_tips;

import api.theme_tips.Theme_tip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Theme_tipRepository extends CrudRepository<Theme_tip, Long> {
    @Query(value="SELECT id FROM Theme_tip WHERE id = (SELECT MAX(id) FROM Theme_tip)")
    Integer findHighestId();
    @Query(value="SELECT * from theme_tips where age_group_id = :age_group_id order by RAND() limit 1 ", nativeQuery = true)
    Theme_tip findRandomTheme_Tip(@Param("age_group_id") int age_group_id);
}