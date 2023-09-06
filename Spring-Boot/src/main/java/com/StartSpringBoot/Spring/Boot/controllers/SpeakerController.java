package com.StartSpringBoot.Spring.Boot.controllers;

import com.StartSpringBoot.Spring.Boot.models.entity.Speakers;
import com.StartSpringBoot.Spring.Boot.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController

@RequestMapping("/api/v1/speaker")
public class SpeakerController {
    @Autowired
    private  SpeakerRepository speakerRepository;

    //private SpeakerRepository = new .....
    @GetMapping
    public List<Speakers>list(){
        return speakerRepository.findAll();
    }

    @GetMapping("/{id}")

    public Speakers get(@PathVariable Long id){
        return  speakerRepository.getReferenceById(id);
    }
    @PostMapping
    public Speakers create(@RequestBody final  Speakers speaker){
        return  speakerRepository.saveAndFlush(speaker);
    }

    @GetMapping
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speakers update(@PathVariable Long id, @RequestBody Speakers speaker) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what has changed.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Speakers existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
