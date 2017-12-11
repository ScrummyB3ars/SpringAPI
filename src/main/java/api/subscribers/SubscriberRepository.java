package api.subscribers;

import api.subscribers.Subscriber;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {
    @Query(value="SELECT id FROM Subscriber WHERE id = (SELECT MAX(id) FROM Subscriber)")
    Integer findHighestId();

    @Transactional
    @Modifying
    @Query(value="DELETE FROM Subscriber where facebook_id = :s")
    void deleteWithFacebook_id(@Param("s") String s);
}