package com.scottcorbat.leagueapi.service;

import com.scottcorbat.leagueapi.database.entity.PlayerStats;
import com.scottcorbat.leagueapi.database.entity.SummonerMatch;
import com.scottcorbat.leagueapi.database.repository.PlayerStatsRepository;
import com.scottcorbat.leagueapi.database.repository.SummonerMatchRepository;
import com.scottcorbat.leagueapi.ui.request.AddMatchRequest;
import com.scottcorbat.leagueapi.ui.request.PlayerStatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final SummonerMatchRepository matchRepo;
    private final PlayerStatsRepository statRepo;

    @Autowired
    public MatchService(SummonerMatchRepository matchRepo, PlayerStatsRepository statRepo) {
        this.matchRepo = matchRepo;
        this.statRepo = statRepo;
    }

    public SummonerMatch addMatch(AddMatchRequest req) {
        SummonerMatch match = new SummonerMatch();
        match.setMatchId(req.getMatchId());
        match.setLength(req.getLength());
        match.setQueueId(req.getQueueId());
        match.setCreated(req.getCreated());

        SummonerMatch saved = matchRepo.save(match);

        //copy over player stats
        for (PlayerStatRequest ps : req.getPlayerStats()) {
            PlayerStats entity = new PlayerStats();
            entity.setMatch(match);

            entity.setSummonerId(ps.getSummonerId());
            entity.setSummonerName(ps.getSummonerName());
            entity.setItemIds(ps.getItemIds());

            statRepo.save(entity);

            match.getPlayerStats().add(entity);
        }

        return saved;
    }

}
