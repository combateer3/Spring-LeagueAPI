package com.scottcorbat.leagueapi.service;

import com.scottcorbat.leagueapi.database.entity.Player;
import com.scottcorbat.leagueapi.database.repository.PlayerRepository;
import com.scottcorbat.leagueapi.exceptions.PlayerServiceException;
import com.scottcorbat.leagueapi.ui.request.AddPlayerRequest;
import com.scottcorbat.leagueapi.ui.response.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public Player getPlayerBySummonerId(String summonerId) {
        Player player = playerRepo.findBySummonerId(summonerId);

        if (player == null) {
            throw new PlayerServiceException(ErrorMessages.SUMMONER_NOT_FOUND.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return player;
    }

}
