package com.scottcorbat.leagueapi.ui.controller;

import com.scottcorbat.leagueapi.database.entity.Player;
import com.scottcorbat.leagueapi.database.entity.SummonerMatch;
import com.scottcorbat.leagueapi.service.MatchService;
import com.scottcorbat.leagueapi.service.PlayerService;
import com.scottcorbat.leagueapi.ui.request.AddMatchRequest;
import com.scottcorbat.leagueapi.ui.request.AddPlayerRequest;
import com.scottcorbat.leagueapi.ui.response.AddMatchRest;
import com.scottcorbat.leagueapi.ui.response.AddPlayerRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("players")
public class LeagueController {

    private final PlayerService playerService;

    private final MatchService matchService;

    @Autowired
    public LeagueController(PlayerService playerService, MatchService matchService) {
        this.playerService = playerService;
        this.matchService = matchService;
    }

    @PostMapping(path = "/add")
    public AddPlayerRest addPlayer(@RequestBody AddPlayerRequest req) {
        Player saved = playerService.addPlayer(req);

        AddPlayerRest res = new AddPlayerRest();
        res.setUsername(saved.getUsername());
        res.setAccountId(saved.getAccountId());
        res.setSummonerId(saved.getSummonerId());
        res.setPuuId(saved.getPuuId());

        return res;
    }

    @PostMapping(path = "{summonerId}/matches")
    public AddMatchRest addPlayerMatch(@RequestBody AddMatchRequest req, @PathVariable String summonerId) {
        //submit match to database
        SummonerMatch match = matchService.addMatch(req, summonerId);

        //populate response
        AddMatchRest res = new AddMatchRest();
        res.setMatchId(match.getMatchId());
        res.setLength(match.getLength());

        return res;
    }

}
