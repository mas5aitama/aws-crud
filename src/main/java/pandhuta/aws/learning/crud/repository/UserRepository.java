package pandhuta.aws.learning.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pandhuta.aws.learning.crud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
