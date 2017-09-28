package com.kodilla.good.patterns.challenges;

public class EMailInformationService implements InformationService {

    public void inform(User user) {
        System.out.println("Hello " + user.getName() + ", we are processing your order!");
    }
}
