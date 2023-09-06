package com.Start.Learn.services.dao;

import com.Start.Learn.entity.Account;
import com.Start.Learn.repositories.AccountRepository;
import com.Start.Learn.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(long id) {
        accountRepository.deleteById(id);

    }

    @Override
    public Optional<Account> findByFirstName(String firstName) {
        return accountRepository.findByFirstName(firstName);
    }
}
