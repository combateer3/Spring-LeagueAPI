package com.scottcorbat.leagueapi.database.repository;

import com.scottcorbat.leagueapi.database.entity.SummonerMatch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummonerMatchRepository extends CrudRepository<SummonerMatch, Integer> {
}
