package com.Full.Full.Stack.App.controller;

import com.Full.Full.Stack.App.entity.MovieEntity;
import com.Full.Full.Stack.App.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public List<MovieEntity> getAllAccountController() {
        return this.accountService.findAllAccounts();
    }

    @PostMapping("/create")
    public MovieEntity createAccountController(@RequestBody MovieEntity bookEntity) {
      return   this.accountService.createAccount(bookEntity);
    }

    @PostMapping("/update")
    public void updateAccountController(@RequestBody MovieEntity bookEntity) {
        this.accountService.updateAccount(bookEntity);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAccountController(@PathVariable("id") Long id) {
        this.accountService.deleteAccount(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MovieEntity> getAccountById(@PathVariable Long id) {
        Optional<MovieEntity> movieOptional = accountService.findAccountById(id);

        if (movieOptional.isPresent()) {
            MovieEntity movie = movieOptional.get();
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
