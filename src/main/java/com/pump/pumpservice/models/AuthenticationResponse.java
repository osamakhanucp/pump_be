package com.pump.pumpservice.models;


import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String token;

    public AuthenticationResponse(String jwt) {
        this.token = jwt;
    }

    public String getJwt() {
        return token;
    }
}