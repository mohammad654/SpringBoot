package com.Full.Full.Stack.App.service;

import com.Full.Full.Stack.App.entity.AccountEntity;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<AccountEntity> findAllAccounts();

    AccountEntity createAccount(AccountEntity bookEntity);

    void updateAccount(AccountEntity bookEntity);

    void deleteAccount(Long id);

    Optional<AccountEntity> findAccountById(Long id);

}
