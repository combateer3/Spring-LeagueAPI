package com.scottcorbat.leagueapi.database.repository;

import com.scottcorbat.leagueapi.database.entity.PlayerStats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatsRepository extends CrudRepository<PlayerStats, Integer> {
}
