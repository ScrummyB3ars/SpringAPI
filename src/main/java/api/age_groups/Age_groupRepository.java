package api.age_groups;

import api.age_groups.Age_group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Age_groupRepository extends CrudRepository<Age_group, Long> {
}
