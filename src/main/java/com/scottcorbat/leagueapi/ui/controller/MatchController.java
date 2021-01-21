package com.scottcorbat.leagueapi.ui.controller;

import com.scottcorbat.leagueapi.database.entity.SummonerMatch;
import com.scottcorbat.leagueapi.service.MatchService;
import com.scottcorbat.leagueapi.ui.request.AddMatchRequest;
import com.scottcorbat.leagueapi.ui.response.AddMatchRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public AddMatchRest addPlayerMatch(@RequestBody AddMatchRequest req) {
        //submit match to database
        SummonerMatch match = matchService.addMatch(req);

        //populate response
        AddMatchRest res = new AddMatchRest();
        res.setMatchId(match.getMatchId());
        res.setLength(match.getLength());

        return res;
    }

}
