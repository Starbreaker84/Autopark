package omalaev.autopark.security;

import omalaev.autopark.models.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ManagerDetails implements UserDetails {
    private final Manager manager;

    @Autowired
    public ManagerDetails(Manager manager) {
        this.manager = manager;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return manager.getManagerPassword();
    }

    @Override
    public String getUsername() {
        return manager.getManagerName();
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

    public Manager getManager() {
        return this.manager;
    }
}
