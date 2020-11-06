package ru.inedtest.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.inedtest.dbtools.domains.user.AppUser;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends CrudRepository<AppUser, UUID> {

    Optional<AppUser> findByEmail(String email);
    boolean existsByEmail(String email);
}
