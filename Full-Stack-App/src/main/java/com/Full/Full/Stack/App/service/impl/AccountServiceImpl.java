package com.Full.Full.Stack.App.service.impl;

import com.Full.Full.Stack.App.Repository.AccountRepository;
import com.Full.Full.Stack.App.entity.MovieEntity;
import com.Full.Full.Stack.App.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<MovieEntity> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public MovieEntity createAccount(MovieEntity bookEntity) {
        return accountRepository.save(bookEntity);
    }

    @Override
    public void updateAccount(MovieEntity bookEntity) {
        accountRepository.save(bookEntity);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Optional<MovieEntity> findAccountById(Long id) {
        return accountRepository.findById(id);
    }

}
