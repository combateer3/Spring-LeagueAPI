package com.scottcorbat.leagueapi.database.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SummonerMatch {

    @Id
    @GeneratedValue
    private long id;

    //game meta stuff
    private String matchId;
    private int queueId;
    private long created;
    private int length;

    @OneToMany(mappedBy = "match")
    private Set<PlayerStats> playerStats = new HashSet<>();

    public Set<PlayerStats> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(Set<PlayerStats> playerStats) {
        this.playerStats = playerStats;
    }

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

    public long getId() {
        return id;
    }

}
