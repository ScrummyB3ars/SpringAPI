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
    @Query(value="DELETE FROM Subscriber where facebook_id = :fb_id")
    void deleteWithFacebook_id(@Param("fb_id") String fb_id);

    @Query(value="SELECT * from subscribers where facebook_id = :fb_id limit 1", nativeQuery = true)
    Subscriber findSubscriberByFacebook_id(@Param("fb_id") int fb_id);
}