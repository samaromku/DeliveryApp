package ru.savchenko.andrey.deliveryapp.entities;

/**
 * Created by savchenko on 26.12.17.
 */

public class Token {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                '}';
    }
}
