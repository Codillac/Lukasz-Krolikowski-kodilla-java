package com.kodilla.good.patterns.challenges.challenge2.services;

import com.kodilla.good.patterns.challenges.challenge2.users.User;

public class EMailInformationService implements InformationService {

    public void inform(User user) {
        System.out.println("Hello " + user.getName() + ", we are processing your order!");
    }
}
