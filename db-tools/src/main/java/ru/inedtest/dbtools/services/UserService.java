package ru.inedtest.dbtools.services;

import ru.inedtest.dbtools.domains.user.AppUser;

import java.util.UUID;

public interface UserService {

    void saveUser(AppUser appUser);
    AppUser findByEmail(String email);
    boolean existsByEmail(String email);
    AppUser findUserById(UUID userId);



}
