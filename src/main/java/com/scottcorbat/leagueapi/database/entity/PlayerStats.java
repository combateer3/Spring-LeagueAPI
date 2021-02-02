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

    private int championId;
    private int teamId;

    private int spell1Id, spell2Id;

    //player stats
    private int totalHeal;
    private int largestMultikill;
    private int goldEarned;
    private int damageToObjectives;
    private int totalMinionsKilled;
    private int kills, deaths, assists;
    private int totalTimeCrowdControlDealt;
    private int doubleKills, tripleKills, quadraKills, pentaKills;
    private int physicalDamageToChampions, magicDamageToChampions, trueDamageToChampions;
    private int visionWardsBoughtInGame;
    private int visionScore, sightWardsBoughtInGame;

    //timeline stats
    private int csPerMin0_10;
    private int csPerMin10_20;
    private int csPerMin20_30;

    @ElementCollection
    private Set<Integer> itemIds;

    public int getPhysicalDamageToChampions() {
        return physicalDamageToChampions;
    }

    public void setPhysicalDamageToChampions(int physicalDamageToChampions) {
        this.physicalDamageToChampions = physicalDamageToChampions;
    }

    public int getMagicDamageToChampions() {
        return magicDamageToChampions;
    }

    public void setMagicDamageToChampions(int magicDamageToChampions) {
        this.magicDamageToChampions = magicDamageToChampions;
    }

    public int getTrueDamageToChampions() {
        return trueDamageToChampions;
    }

    public void setTrueDamageToChampions(int trueDamageToChampions) {
        this.trueDamageToChampions = trueDamageToChampions;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal(int totalHeal) {
        this.totalHeal = totalHeal;
    }

    public int getLargestMultikill() {
        return largestMultikill;
    }

    public void setLargestMultikill(int largestMultikill) {
        this.largestMultikill = largestMultikill;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getDamageToObjectives() {
        return damageToObjectives;
    }

    public void setDamageToObjectives(int damageToObjectives) {
        this.damageToObjectives = damageToObjectives;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public void setTotalMinionsKilled(int totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getTotalTimeCrowdControlDealt() {
        return totalTimeCrowdControlDealt;
    }

    public void setTotalTimeCrowdControlDealt(int totalTimeCrowdControlDealt) {
        this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    }

    public int getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills(int doubleKills) {
        this.doubleKills = doubleKills;
    }

    public int getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills(int tripleKills) {
        this.tripleKills = tripleKills;
    }

    public int getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills(int quadraKills) {
        this.quadraKills = quadraKills;
    }

    public int getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills(int pentaKills) {
        this.pentaKills = pentaKills;
    }

    public int getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(int visionScore) {
        this.visionScore = visionScore;
    }

    public int getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public void setSightWardsBoughtInGame(int sightWardsBoughtInGame) {
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    }

    public int getCsPerMin0_10() {
        return csPerMin0_10;
    }

    public void setCsPerMin0_10(int csPerMin0_10) {
        this.csPerMin0_10 = csPerMin0_10;
    }

    public int getCsPerMin10_20() {
        return csPerMin10_20;
    }

    public void setCsPerMin10_20(int csPerMin10_20) {
        this.csPerMin10_20 = csPerMin10_20;
    }

    public int getCsPerMin20_30() {
        return csPerMin20_30;
    }

    public void setCsPerMin20_30(int csPerMin20_30) {
        this.csPerMin20_30 = csPerMin20_30;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(int spell1Id) {
        this.spell1Id = spell1Id;
    }

    public int getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(int spell2Id) {
        this.spell2Id = spell2Id;
    }

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
