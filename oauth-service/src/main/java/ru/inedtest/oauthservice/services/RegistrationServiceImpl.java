package ru.inedtest.oauthservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inedtest.dbtools.dto.othersDTO.RegistrationDTO;
import ru.inedtest.dbtools.repositories.UserRepo;
import ru.inedtest.dbtools.services.UserService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;


    @Autowired
    public RegistrationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void registration(RegistrationDTO registrationDTO) {

    }


}
