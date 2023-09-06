package com.Full.Full.Stack.App.controller;

import com.Full.Full.Stack.App.entity.AccountEntity;
import com.Full.Full.Stack.App.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String getAllAccounts(Model model) {
        List<AccountEntity> accountEntities = accountService.findAllAccounts();
        model.addAttribute("accounts", accountEntities);
        return "index";
    }
    @GetMapping("/about")
    public String about( ) {

        return "about";
    }
    @GetMapping("/dashboard")
    public String getDashboard() {

        return "dashboard";
    }
    @PostMapping("/addAccount")
    public String addAccount(@ModelAttribute("account") AccountEntity accountEntity) {
        AccountEntity result = accountService.createAccount(accountEntity);
        if (result == null) {
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping({"/edite", "/edit/{id}"})
    public String editAccount(Model model, @PathVariable(value = "id", required = false) Long id) {
        if (id != null) {
            Optional<AccountEntity> accountEntity = accountService.findAccountById(id);
            if (accountEntity.isPresent()) {
                model.addAttribute("account", accountEntity.get());
            } else {
                model.addAttribute("account", new AccountEntity());
            }
        } else {
            model.addAttribute("account", new AccountEntity());
        }
        return "add-edit-account";
    }

    @GetMapping("/delete/{accountId}")
    public String deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.deleteAccount(accountId);
        return "redirect:/";
    }

}