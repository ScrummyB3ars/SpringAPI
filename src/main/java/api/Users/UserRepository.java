package api.Users;

import api.Users.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value="SELECT id FROM User WHERE id = (SELECT MAX(id) FROM User)")
    Integer findHighestId();

    @Transactional
    @Modifying
    @Query(value="DELETE FROM User where email = :s")
    void deleteWithEmail(@Param("s") String s);

    @Query(value="SELECT * from users where id = :id limit 1", nativeQuery = true)
    User findUserById(@Param("id") int id);
}