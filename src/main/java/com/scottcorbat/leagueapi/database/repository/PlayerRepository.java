package com.scottcorbat.leagueapi.database.repository;

import com.scottcorbat.leagueapi.database.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

    Player findBySummonerId(String summonerId);

}
