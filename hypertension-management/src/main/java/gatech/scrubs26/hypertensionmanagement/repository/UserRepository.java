package gatech.scrubs26.hypertensionmanagement.repository;


import gatech.scrubs26.hypertensionmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
