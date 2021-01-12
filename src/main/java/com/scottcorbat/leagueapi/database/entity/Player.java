package com.scottcorbat.leagueapi.database.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"accountId", "summonerId"})})
public class Player {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String accountId;
    private String summonerId;
    private String puuId;

    @OneToMany(mappedBy = "player")
    private Set<SummonerMatch> summonerMatches;

    public Set<SummonerMatch> getSummonerMatches() {
        return summonerMatches;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getPuuId() {
        return puuId;
    }

    public void setPuuId(String puuId) {
        this.puuId = puuId;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
