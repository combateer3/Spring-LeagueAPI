package com.scottcorbat.leagueapi.ui.response;

public enum ErrorMessages {

    SUMMONER_NOT_FOUND("A summoner matching that summoner ID was not found!");

    private String msg;

    public String getMessage() {
        return msg;
    }

    ErrorMessages(String msg) {
        this.msg = msg;
    }
}
