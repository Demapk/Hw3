package ru.kpfu.itis.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kpfu.itis.model.Role;
import ru.kpfu.itis.model.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class UserDetailsImpl implements UserDetails {


    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    /**
     * @return коллекция прав доступа пользователя
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities(user.getRoles());
    }

    private static Collection<GrantedAuthority> getAuthorities(Collection<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>(5);
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
    }

    /**
     * hash of password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Логин (имя) пользователя
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * @return флаг, что срок действия аккаунта еще не истек, он активен
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь не заблокирован администраторами сайта
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return флаг, что срок действия пароля еще не истек, он активен
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь включен и подтвержден
     */
    @Override
    public boolean isEnabled() {
        return true;
    }


}
