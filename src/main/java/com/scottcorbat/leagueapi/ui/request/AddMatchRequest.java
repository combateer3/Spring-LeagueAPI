package com.scottcorbat.leagueapi.ui.request;

import java.util.Set;

public class AddMatchRequest {

    private String matchId;
    private int queueId;
    private long created;
    private int length;

    private Set<PlayerStatRequest> playerStats;

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public Set<PlayerStatRequest> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(Set<PlayerStatRequest> playerStats) {
        this.playerStats = playerStats;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
