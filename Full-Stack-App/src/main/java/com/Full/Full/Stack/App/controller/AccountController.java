package com.Full.Full.Stack.App.controller;

import com.Full.Full.Stack.App.entity.MovieEntity;
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
        List<MovieEntity> accountEntities = accountService.findAllAccounts();
        model.addAttribute("movies", accountEntities);
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
    public String addAccount(@ModelAttribute("movies") MovieEntity accountEntity) {
        MovieEntity result = accountService.createAccount(accountEntity);
        if (result == null) {
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping({"/edite", "/edit/{id}"})
    public String editAccount(Model model, @PathVariable(value = "id", required = false) Long id) {
        if (id != null) {
            Optional<MovieEntity> accountEntity = accountService.findAccountById(id);
            if (accountEntity.isPresent()) {
                model.addAttribute("movies", accountEntity.get());
            } else {
                model.addAttribute("movies", new MovieEntity());
            }
        } else {
            model.addAttribute("movies", new MovieEntity());
        }
        return "add-edit-account";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable("id") Long accountId) {
        accountService.deleteAccount(accountId);
        return "redirect:/";
    }

}