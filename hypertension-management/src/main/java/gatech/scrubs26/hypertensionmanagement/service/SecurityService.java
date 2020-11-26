package gatech.scrubs26.hypertensionmanagement.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}