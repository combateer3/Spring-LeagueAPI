package com.scottcorbat.leagueapi.service;

import com.scottcorbat.leagueapi.database.entity.Player;
import com.scottcorbat.leagueapi.database.entity.SummonerMatch;
import com.scottcorbat.leagueapi.database.repository.PlayerRepository;
import com.scottcorbat.leagueapi.database.repository.SummonerMatchRepository;
import com.scottcorbat.leagueapi.ui.request.AddMatchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final PlayerRepository playerRepo;

    private final SummonerMatchRepository matchRepo;

    @Autowired
    public MatchService(PlayerRepository playerRepo, SummonerMatchRepository matchRepo) {
        this.playerRepo = playerRepo;
        this.matchRepo = matchRepo;
    }

    public SummonerMatch addMatch(AddMatchRequest req, String summonerId) {
        //get the player associated with the summoner id
        Player player = playerRepo.findBySummonerId(summonerId);

        SummonerMatch match = new SummonerMatch();
        match.setPlayer(player);
        match.setMatchId(req.getMatchId());
        match.setLength(req.getLength());

        return matchRepo.save(match);
    }

}
