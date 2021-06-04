package com.scottcorbat.leagueapi.service;

import com.scottcorbat.leagueapi.database.entity.UserEntity;
import com.scottcorbat.leagueapi.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUserId(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(user.getUserId(), user.getEncryptedPassword(), new ArrayList<>());
    }

}
