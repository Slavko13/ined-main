package ru.inedtest.booksapi.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.inedtest.oauthservice.config.CommonSecurityConfig;

@Configuration
@EnableWebSecurity
@Import({CommonSecurityConfig.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/api/**").anonymous()
                .antMatchers(HttpMethod.GET, "/user/api/**").anonymous()
                .antMatchers(HttpMethod.POST, "/admin/api/**").anonymous()
                .antMatchers(HttpMethod.GET, "/admin/api/**").anonymous()
                .antMatchers(HttpMethod.POST, "/main/api/**").anonymous()
                .antMatchers(HttpMethod.GET, "/main/api/**").anonymous()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
