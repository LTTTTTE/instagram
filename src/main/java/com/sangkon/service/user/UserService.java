package com.sangkon.service.user;

import com.sangkon.model.user.User;
import com.sangkon.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username).orElse(null);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
