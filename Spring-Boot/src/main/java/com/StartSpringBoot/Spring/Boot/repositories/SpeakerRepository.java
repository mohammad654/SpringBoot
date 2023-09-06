package com.StartSpringBoot.Spring.Boot.repositories;

import com.StartSpringBoot.Spring.Boot.models.entity.Speakers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speakers,Long> {


}
