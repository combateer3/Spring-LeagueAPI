package com.scottcorbat.leagueapi.database.repository;

import com.scottcorbat.leagueapi.database.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUserId(String userId);

}
