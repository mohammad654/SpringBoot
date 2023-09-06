package com.StartSpringBoot.Spring.Boot.controllers;
import com.StartSpringBoot.Spring.Boot.models.entity.Test;
import com.StartSpringBoot.Spring.Boot.repositories.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestRepo testRepo;

    @GetMapping
    public String list(Model model) {
        List<Test> tests = testRepo.findAll();
        model.addAttribute("tests", tests);
        return "test";
    }

    @GetMapping("/{id}/info")
    public String idInfo(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "id_info";
    }

}
