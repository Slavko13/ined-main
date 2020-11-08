package ru.inedtest.booksapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inedtest.dbtools.dto.userDTO.AuthenticationRequestDto;
import ru.inedtest.dbtools.dto.userDTO.JwtAuthenticationResponse;
import ru.inedtest.oauthservice.services.AuthService;


@RestController
@RequestMapping("/api/auth/login")
public class AuthController {

    private final AuthService  authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<JwtAuthenticationResponse>  signIn(@RequestBody AuthenticationRequestDto loginDTO) {
        return new ResponseEntity<>(authService.signIn(loginDTO), HttpStatus.OK);
    }

}
