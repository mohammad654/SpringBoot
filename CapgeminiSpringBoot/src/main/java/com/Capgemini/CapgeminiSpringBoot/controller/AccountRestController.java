package com.Capgemini.CapgeminiSpringBoot.controller;


import com.Capgemini.CapgeminiSpringBoot.entity.AccountEntity;
import com.Capgemini.CapgeminiSpringBoot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/")

public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public List<AccountEntity> getAllAccountController() {
        return this.accountService.findAllAccounts();
    }

    @PostMapping("/create")
    public AccountEntity createAccountController(@RequestBody AccountEntity bookEntity) {
      return   this.accountService.createAccount(bookEntity);
    }

    @PostMapping("/update")
    public void updateAccountController(@RequestBody AccountEntity bookEntity) {
        this.accountService.updateAccount(bookEntity);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAccountController(@PathVariable("id") Long id) {
        this.accountService.deleteAccount(id);
    }
}
