package com.example.service.user;

import com.example.dto.user.UserRegistrationRequestDto;
import com.example.dto.user.UserResponseDto;
import com.example.exception.exceptions.RegistrationException;
import com.example.mapper.UserMapper;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.role.RoleRepository;
import com.example.repository.user.UserRepository;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {

        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new RegistrationException("Email is already registered");
        }

        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole(Role.RoleName.ROLE_USER)
                .orElseThrow(() -> new NoSuchElementException("Role not found"));
        user.setRoles(new HashSet<>(Set.of(userRole)));
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
