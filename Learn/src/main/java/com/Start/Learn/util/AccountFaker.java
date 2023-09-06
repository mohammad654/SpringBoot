package com.Start.Learn.util;

import com.Start.Learn.entity.Account;
import com.github.javafaker.Faker;

public class AccountFaker {

    private static final Faker faker = new Faker();

    public static Account createFakeAccount() {
        Account account = new Account();
        account.setFirstName(faker.name().firstName());
        account.setLastName(faker.name().lastName());
        account.setPhoneNumber(faker.phoneNumber().phoneNumber());
        account.setEmail(faker.internet().emailAddress());
        account.setPassword(faker.internet().password());
        account.setRole(faker.job().title());
        return account;
    }
}
