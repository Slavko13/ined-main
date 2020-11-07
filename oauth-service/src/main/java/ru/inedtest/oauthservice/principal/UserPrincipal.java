package ru.inedtest.oauthservice.principal;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.inedtest.dbtools.domains.user.AppUser;
import ru.inedtest.dbtools.domains.user.Status;

import java.util.Collection;
import java.util.Set;

@Getter
public class UserPrincipal implements UserDetails {

    private final String password;
    private final String username;
    private final Set<GrantedAuthority> authorities;
    private final boolean enabled;

    public UserPrincipal(AppUser appUser) {
        this.password = appUser.getPassword();
        this.username = appUser.getEmail();
        this.authorities = Set.of(new SimpleGrantedAuthority(appUser.getRole().getName()));
        this.enabled = appUser.getStatus().equals(Status.ACTIVE);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
