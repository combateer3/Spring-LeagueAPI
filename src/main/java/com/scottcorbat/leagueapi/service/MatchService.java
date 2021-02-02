package com.scottcorbat.leagueapi.service;

import com.scottcorbat.leagueapi.database.entity.PlayerStats;
import com.scottcorbat.leagueapi.database.entity.SummonerMatch;
import com.scottcorbat.leagueapi.database.repository.PlayerStatsRepository;
import com.scottcorbat.leagueapi.database.repository.SummonerMatchRepository;
import com.scottcorbat.leagueapi.ui.request.AddMatchRequest;
import org.modelmapper.ModelMapper;
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
        ModelMapper mapper = new ModelMapper();
        SummonerMatch match = mapper.map(req, SummonerMatch.class);

        SummonerMatch saved = matchRepo.save(match);

        for (PlayerStats ps : match.getPlayerStats()) {
            ps.setMatch(saved);
            statRepo.save(ps);
        }

        return saved;
    }

}
