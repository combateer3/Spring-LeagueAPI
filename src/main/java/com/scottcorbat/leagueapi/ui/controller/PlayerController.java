package com.scottcorbat.leagueapi.ui.controller;

import com.scottcorbat.leagueapi.database.entity.Player;
import com.scottcorbat.leagueapi.service.PlayerService;
import com.scottcorbat.leagueapi.ui.request.AddPlayerRequest;
import com.scottcorbat.leagueapi.ui.response.AddPlayerRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
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

}
