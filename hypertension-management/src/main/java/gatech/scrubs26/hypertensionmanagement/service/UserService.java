package gatech.scrubs26.hypertensionmanagement.service;

import gatech.scrubs26.hypertensionmanagement.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
