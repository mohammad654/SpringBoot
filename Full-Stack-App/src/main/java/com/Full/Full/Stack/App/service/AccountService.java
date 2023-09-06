package com.Full.Full.Stack.App.service;

import com.Full.Full.Stack.App.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<MovieEntity> findAllAccounts();

    MovieEntity createAccount(MovieEntity bookEntity);

    void updateAccount(MovieEntity bookEntity);

    void deleteAccount(Long id);

    Optional<MovieEntity> findAccountById(Long id);
}
