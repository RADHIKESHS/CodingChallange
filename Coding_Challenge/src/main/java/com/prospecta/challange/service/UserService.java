package com.prospecta.challange.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prospecta.challange.model.Role;
import com.prospecta.challange.model.Users;
import com.prospecta.challange.repository.UserRepository;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Users saveUser(Users user) throws Exception {
    	Optional<Users> u= userRepository.findByEmail(user.getEmail());;
    	if(u.isPresent()) {
    		throw new Exception("Username Already Present,should be Unique");
    	}else {
    		user.setPassword(passwordEncoder.encode(user.getPassword()));
    		user.setRole(Role.USER);
    		return userRepository.save(user);
    	}
    }
    
    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}

