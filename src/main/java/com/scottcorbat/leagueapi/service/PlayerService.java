package com.scottcorbat.leagueapi.service;

import com.scottcorbat.leagueapi.database.entity.Player;
import com.scottcorbat.leagueapi.database.repository.PlayerRepository;
import com.scottcorbat.leagueapi.ui.request.AddPlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepo;

    @Autowired
    public PlayerService(PlayerRepository playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player addPlayer(AddPlayerRequest req) {
        Player player = new Player();
        player.setUsername(req.getUsername());
        player.setAccountId(req.getAccountId());
        player.setSummonerId(req.getSummonerId());
        player.setPuuId(req.getPuuId());

        return playerRepo.save(player);
    }

}
