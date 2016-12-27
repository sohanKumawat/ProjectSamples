package ai.msg.security;

import java.util.Optional;

import ai.msg.entity.User;

/**
 * 
 * @author Sohan Kumawat
 *
 * Aug 17, 2016
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
}
