package com.scottcorbat.leagueapi.ui.request;

public class AddMatchRequest {

    private String matchId;
    private int length;

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