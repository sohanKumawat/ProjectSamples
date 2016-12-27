package ai.msg.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.msg.entity.User;
import ai.msg.security.UserService;
import ai.msg.user.repository.UserRepository;

/**
 * Mock implementation.
 * 
 * @author Sohan Kumawat
 *
 * Aug 4, 2016
 */
@Service
public class DatabaseUserService implements UserService {
    private final UserRepository userRepository;
    
    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
