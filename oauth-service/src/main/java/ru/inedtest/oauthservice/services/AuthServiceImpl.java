package ru.inedtest.oauthservice.services;

import org.springframework.stereotype.Service;
import ru.inedtest.dbtools.domains.user.AppUser;
import ru.inedtest.dbtools.dto.userDTO.AuthenticationRequestDto;
import ru.inedtest.dbtools.dto.userDTO.JwtAuthenticationResponse;
import ru.inedtest.dbtools.services.UserService;
import ru.inedtest.oauthservice.jwt.JwtTokenProvider;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @Override
    public JwtAuthenticationResponse signIn(AuthenticationRequestDto authenticationRequestDto) {
        AppUser appUser = userService.findByEmail(authenticationRequestDto.getEmail());
        String token = jwtTokenProvider.generateToken(appUser.getEmail(), appUser.getRole());
        return new JwtAuthenticationResponse(token);
    }
}
