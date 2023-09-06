package com.Start.Learn.services;

import com.Start.Learn.entity.Account;

import java.util.Optional;

public interface AccountService {
    Iterable<Account> findAll();
    Optional<Account> findById(long id);
    Account save(Account account);
    void deleteById( long id);
    Optional<Account> findByFirstName (String firstName);
}
