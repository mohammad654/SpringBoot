package com.Capgemini.CapgeminiSpringBoot.service.impl;


import com.Capgemini.CapgeminiSpringBoot.Repository.AccountRepository;
import com.Capgemini.CapgeminiSpringBoot.entity.AccountEntity;
import com.Capgemini.CapgeminiSpringBoot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository bookRepository;

    @Override
    public List<AccountEntity> findAllAccounts() {
        return bookRepository.findAll();
    }

    @Override
    public AccountEntity createAccount(AccountEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public void updateAccount(AccountEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    @Override
    public void deleteAccount(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<AccountEntity> findAccountById(Long id) {
        return bookRepository.findById(id);
    }
}
