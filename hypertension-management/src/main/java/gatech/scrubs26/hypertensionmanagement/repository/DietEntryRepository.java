package gatech.scrubs26.hypertensionmanagement.repository;

import gatech.scrubs26.hypertensionmanagement.model.DietEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DietEntryRepository extends JpaRepository<DietEntry, Long> {
    List<DietEntry> findByUsername(String username);

    @Query(value = "Select d From DietEntry d where username = :username Order By created_date desc")
    List<DietEntry> findCurrentDietEntries(@Param("username") String username);
}

