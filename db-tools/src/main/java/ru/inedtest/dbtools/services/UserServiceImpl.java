package ru.inedtest.dbtools.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.inedtest.base.exceptions.NotFoundException;
import ru.inedtest.dbtools.domains.user.AppUser;
import ru.inedtest.dbtools.repositories.UserRepo;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;


    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    @Transactional
    public void saveUser(AppUser appUser) {
        userRepo.save(appUser);
    }

    @Override
    @Transactional
    public AppUser findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("{UserServiceImpl.findByEmail.NotFound}"));
    }

    @Override
    @Transactional
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    @Transactional
    public AppUser findUserById(UUID userId) {
        return userRepo.findById(userId).orElseThrow(()-> new NotFoundException("{UserServiceImpl.findByEmail.NotFound}"));
    }
}
