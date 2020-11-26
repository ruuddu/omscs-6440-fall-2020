package gatech.scrubs26.hypertensionmanagement.repository;

import gatech.scrubs26.hypertensionmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
