package ru.inedtest.oauthservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.inedtest.base.exceptions.BadRequestException;
import ru.inedtest.base.exceptions.InternalServerException;
import ru.inedtest.dbtools.domains.user.AppUser;
import ru.inedtest.dbtools.domains.user.Status;
import ru.inedtest.dbtools.dto.othersDTO.RegistrationDTO;
import ru.inedtest.dbtools.services.UserService;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public RegistrationServiceImpl(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registration(RegistrationDTO registrationDTO) {
        boolean emailBusy = userService.existsByEmail(registrationDTO.getEmail());
        if (emailBusy) {
            throw new BadRequestException(Map.of("email", Set.of("{RegistrationServiceImpl.registration.emailBusy}")));
        }

        try {
            AppUser appUser = AppUser.builder()
                    .id(UUID.randomUUID())
                    .firstName(registrationDTO.getFirstName())
                    .lastName(registrationDTO.getLastName())
                    .email(registrationDTO.getEmail())
                    .password(passwordEncoder.encode(registrationDTO.getPassword()))
                    .status(Status.ACTIVE)
                    //.role(new Role("ROLE_GUEST"))
                    .build();
            userService.saveUser(appUser);
        }
        catch (Exception ex) {
            throw new InternalServerException("{RegistrationServiceImpl.registration.internalServerException}", ex);
        }


    }


}
