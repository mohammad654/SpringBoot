package com.pluralsight.springdata.repositories;

import com.pluralsight.springdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findByActive(boolean active);

    List<User> findAllByOrderByUsernameAsc();

    List<User> findByLevelOrderByUsernameDesc(int level);

    List<User> findByRegistrationDateBetween(LocalDate start, LocalDate end);

    List<User> findByUsernameIgnoreCase(String username);

    List<User> findByLevelGreaterThanEqual(int level);

    List<User> findByUsernameContaining(String text);

    List<User> findByUsernameLike(String text);

    List<User> findByUsernameStartingWith(String start);

    List<User> findByUsernameEndingWith(String end);

    List<User> findByRegistrationDateIn(Collection<LocalDate> dates);

    List<User> findByRegistrationDateNotIn(Collection<LocalDate> dates);

    List<User> findByUsernameAndEmail(String username, String email);

    List<User> findByUsernameOrEmail(String username, String email);

}
