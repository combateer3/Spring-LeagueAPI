package com.scottcorbat.leagueapi;

import com.scottcorbat.leagueapi.database.entity.UserEntity;
import com.scottcorbat.leagueapi.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InitialAdminSetup {

    private static final String ADMIN_USERNAME = "combateer3";

    private final UserRepository userRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    //password from application.properties
    @Value("${admin.password}")
    private String adminPassword;

    @Autowired
    public InitialAdminSetup(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        //check if admin user already exists
        UserEntity admin = userRepo.findByUserId(ADMIN_USERNAME);
        //if admin already exists, exit
        if (admin != null) {
            return;
        }

        admin = new UserEntity();
        admin.setUserId(ADMIN_USERNAME);
        admin.setEncryptedPassword(passwordEncoder.encode(adminPassword));

        userRepo.save(admin);
    }

}
