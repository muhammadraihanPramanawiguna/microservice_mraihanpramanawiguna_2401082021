package raihan.order.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raihan.order.order.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}