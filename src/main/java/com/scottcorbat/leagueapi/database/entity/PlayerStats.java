package com.scottcorbat.leagueapi.database.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PlayerStats {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "summoner_match_id")
    private SummonerMatch match;

    //not mapped to Player object since Player table is the players we care about tracking NOT all players
    private String summonerId;
    private String summonerName;

    @ElementCollection
    private Set<Integer> itemIds;

    public Set<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<Integer> itemIds) {
        this.itemIds = itemIds;
    }

    public long getId() {
        return id;
    }

    public SummonerMatch getMatch() {
        return match;
    }

    public void setMatch(SummonerMatch match) {
        this.match = match;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }
}
