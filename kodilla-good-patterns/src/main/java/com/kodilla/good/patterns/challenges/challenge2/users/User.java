package com.kodilla.good.patterns.challenges.challenge2.users;

public class User {

    private String nickname;
    private String name;
    private String surname;

    public User(final String nickname, final String name, final String surname) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
