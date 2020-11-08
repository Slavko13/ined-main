package ru.inedtest.booksapi.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.inedtest.oauthservice.config.CommonSecurityConfig;
import ru.inedtest.oauthservice.jwt.JwtTokenFilter;

@Configuration
@EnableWebSecurity
@Import({CommonSecurityConfig.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenFilter jwtTokenFilter;
    private final UserDetailsService userDetailsService;

    private static final String ADMIN_ENDPOINT = "/admin/api/**";
    private static final String LOGIN_ENDPOINT = "/api/auth/login";

    public SecurityConfig(BCryptPasswordEncoder passwordEncoder, JwtTokenFilter jwtTokenFilter, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenFilter = jwtTokenFilter;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/api/newUser").permitAll()
                .antMatchers(HttpMethod.GET, "/user/api/comments/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, ADMIN_ENDPOINT).hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, ADMIN_ENDPOINT).hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/main/api/**").permitAll()
                .antMatchers(HttpMethod.GET, "/main/api/**").permitAll()
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }




}
