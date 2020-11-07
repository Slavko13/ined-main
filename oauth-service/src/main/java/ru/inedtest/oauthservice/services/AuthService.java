package ru.inedtest.oauthservice.services;

import ru.inedtest.dbtools.dto.userDTO.AuthenticationRequestDto;
import ru.inedtest.dbtools.dto.userDTO.JwtAuthenticationResponse;

public interface AuthService {

    JwtAuthenticationResponse signIn(AuthenticationRequestDto authenticationRequestDto);


}
