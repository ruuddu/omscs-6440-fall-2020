package gatech.scrubs26.hypertensionmanagement.service;

import gatech.scrubs26.hypertensionmanagement.model.DietEntry;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DietEntryService {
    void save(DietEntry entry);

    List<DietEntry> findByUsername(String username);

    List<DietEntry> findCurrentDietEntries(String username);
}
