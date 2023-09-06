package com.StartSpringBoot.Spring.Boot.controllers;

import org.springframework.stereotype.Controller;
import com.StartSpringBoot.Spring.Boot.models.entity.Sessions;
import com.StartSpringBoot.Spring.Boot.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;

//@RestController
@Controller
@RequestMapping("/api/v1/sessions")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Sessions> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Sessions get(@PathVariable Long id) {
        return sessionRepository.getReferenceById(id);
    }

    @PostMapping
    public Sessions create(@RequestBody final Sessions sessions) {
        return sessionRepository.saveAndFlush(sessions);
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Sessions update(@PathVariable Long id, @RequestBody Sessions session) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what has changed.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Sessions existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
