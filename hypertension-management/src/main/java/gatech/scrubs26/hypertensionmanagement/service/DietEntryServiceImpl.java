package gatech.scrubs26.hypertensionmanagement.service;

import gatech.scrubs26.hypertensionmanagement.model.DietEntry;
import gatech.scrubs26.hypertensionmanagement.repository.DietEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietEntryServiceImpl implements DietEntryService {
    @Autowired
    DietEntryRepository dietEntryRepository;

    @Override
    public void save(DietEntry entry) {
        dietEntryRepository.save(entry);
    }

    @Override
    public List<DietEntry> findByUsername(String username) {
        return dietEntryRepository.findByUsername(username);
    }

    @Override
    public List<DietEntry> findCurrentDietEntries(String username) {
        return dietEntryRepository.findCurrentDietEntries(username);
    }


}
