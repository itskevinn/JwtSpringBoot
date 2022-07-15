package com.kevcode.jwtpractice.application.security.service;

import com.kevcode.jwtpractice.domain.security.entity.User;
import com.kevcode.jwtpractice.infrastructure.security.entity.PrincipalUser;
import com.kevcode.jwtpractice.infrastructure.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUserRepository _userRepository;

    @Autowired
    public UserDetailsServiceImpl(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = _userRepository.findByUsername(username).orElse(null);
        assert user != null;
        return PrincipalUser.build(user);
    }
}
