package com.Start.Learn.controllers;


import com.Start.Learn.entity.Account;
import com.Start.Learn.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountService accountService;

    // Endpoint
    // http://localhost:8080/account
//    {
//    "firstName":"Mohammad",
//    "lastName":"sh",
//    "phoneNumber":11,
//      "email":"mo@cap.com",
//        "password":"1!",
//        "role":"admin"
//        }
    // POST
    @PostMapping(value = "/account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok().body(accountService.save(account));
    }

    // Endpoint
    // http://localhost:8080/account
    // GET
    @GetMapping(value = "/account", produces = "application/json")
    public ResponseEntity<Iterable<Account>> getAllAccount() {
        Iterable<Account> accounts = accountService.findAll();
        return ResponseEntity.ok( accounts);
    }

    // Endpoint
    // http://localhost:8080/account/2
    // DEL
    @DeleteMapping("account/{id}")
    public ResponseEntity<Void> deleteAccountId(@PathVariable long id) {
        accountService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "", produces = "application/json")
    public String getHome() {
        return "Home";
    }

    // Endpoint
    // http://localhost:8080/account
    // GET
    @GetMapping(value = "/account/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getAccountById(@PathVariable long id) {
        Optional<Account> account = accountService.findById(id);
        return account.isPresent() ? ResponseEntity.ok(account.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/account/firstName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getAccountByFirstName(@PathVariable String firstName) {
        Optional<Account> account = accountService.findByFirstName(firstName);
        return account.isPresent() ? ResponseEntity.ok(account.get()) : ResponseEntity.notFound().build();
    }
}
