package ru.inedtest.booksapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inedtest.dbtools.dto.othersDTO.RegistrationDTO;
import ru.inedtest.oauthservice.services.RegistrationService;

@RestController
@RequestMapping("/user/api")
public class UserController {

    private final RegistrationService registrationService;


    @Autowired
    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping("/newUser")
    @CrossOrigin
    public ResponseEntity registrateUser(@RequestBody RegistrationDTO registrationDTO) {
        registrationService.registration(registrationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
