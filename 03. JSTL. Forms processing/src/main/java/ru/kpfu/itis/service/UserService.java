package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.RoleEnumeration;
import ru.kpfu.itis.repository.RoleRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.interfaces.IUserService;
import ru.kpfu.itis.util.UserDetailsImpl;
import ru.kpfu.itis.util.UserDto;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService, IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("No user found");
        }
        return new UserDetailsImpl(user);
    }

    @Override
    @Transactional
    public boolean saveIfNotExists(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            return false;
        }
        userRepository.save(transformFromDto(userDto));
        return true;
    }

    private User transformFromDto(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRoles(Collections.singletonList(roleRepository.findByName(RoleEnumeration.USER)));
        return user;
    }
}
