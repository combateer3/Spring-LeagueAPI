package com.scottcorbat.leagueapi.exceptions;

import org.springframework.http.HttpStatus;

public class PlayerServiceException extends RuntimeException {

    private HttpStatus status;

    public PlayerServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
