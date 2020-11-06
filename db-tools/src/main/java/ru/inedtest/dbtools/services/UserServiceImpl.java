package ru.inedtest.dbtools.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inedtest.dbtools.domains.user.AppUser;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {





    @Override
    @Transactional
    public void saveUser(AppUser appUser) {

    }

    @Override
    @Transactional
    public AppUser findByEmail(String email) {
        return null;
    }

    @Override
    @Transactional
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    @Transactional
    public AppUser findUserById(UUID userId) {
        return null;
    }

    @Override
    @Transactional
    public void deleteUserByEmail(String email) {

    }
}
