package com.pluralsight.springdata.repositories;

import com.pluralsight.springdata.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
