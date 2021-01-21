package com.scottcorbat.leagueapi.ui.request;

import java.util.Set;

public class PlayerStatRequest {

    private String summonerId;
    private String summonerName;

    private Set<Integer> itemIds;

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

    public Set<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
