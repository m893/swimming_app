package com.project.Swimming_coach.service.impl;

import com.project.Swimming_coach.mapper.UserMapper;
import com.project.Swimming_coach.model.dto.AuthResponseDto;
import com.project.Swimming_coach.model.dto.UserLoginRequestDto;
import com.project.Swimming_coach.model.dto.UserRegisterRequestDto;
import com.project.Swimming_coach.model.entity.Users;
import com.project.Swimming_coach.model.enums.Role;
import com.project.Swimming_coach.model.enums.Status;
import com.project.Swimming_coach.repository.UserRepository;
import com.project.Swimming_coach.security.JwtService;
import com.project.Swimming_coach.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


     private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponseDto register(UserRegisterRequestDto userRequestDto) {
        if(userRepository.existsByEmail(userRequestDto.getEmail()))
        {
            System.out.println("exit");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
        if(userRepository.existsByUsername(userRequestDto.getUsername()))
        {
            System.out.println("user exist");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
        Users user = new Users();
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setRole(Role.PARENT); // default
        user.setStatus(Status.ACTIVE);
        user.setCreated_at(LocalDate.now());
        user.setFull_name(userRequestDto.getFullName());
        user.setPhone_number(userRequestDto.getPhoneNumber());

        userRepository.save(user);
        String token = jwtService.generateToken(user.getUsername(), user.getRole().name(),user.getStatus().name());
        return new AuthResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFull_name(),
                user.getPhone_number(),
                user.getRole().name(),
                user.getStatus().name(),
                user.getCreated_at(),
                token
        );

    }

    @Override
    public AuthResponseDto coachRegister(UserRegisterRequestDto userRequestDto) {
        if(userRepository.existsByEmail(userRequestDto.getEmail()))
        {
            System.out.println("exit");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
        if(userRepository.existsByUsername(userRequestDto.getUsername()))
        {
            System.out.println("user exist");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
        Users user = new Users();
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setRole(Role.COACH); // default
        user.setStatus(Status.ACTIVE);
        user.setCreated_at(LocalDate.now());
        user.setFull_name(userRequestDto.getFullName());
        user.setPhone_number(userRequestDto.getPhoneNumber());

        userRepository.save(user);
        String token = jwtService.generateToken(user.getUsername(), user.getRole().name(),user.getStatus().name());
        return new AuthResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFull_name(),
                user.getPhone_number(),
                user.getRole().name(),
                user.getStatus().name(),
                user.getCreated_at(),
                token
        );
    }

    @Override
    public AuthResponseDto adminRegister(UserRegisterRequestDto userRequestDto) {
        if(userRepository.existsByEmail(userRequestDto.getEmail()))
        {
            System.out.println("exit");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
        if(userRepository.existsByUsername(userRequestDto.getUsername()))
        {
            System.out.println("user exist");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
        Users user = new Users();
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setRole(Role.ADMIN); // default
        user.setStatus(Status.ACTIVE);
        user.setCreated_at(LocalDate.now());
        user.setFull_name(userRequestDto.getFullName());
        user.setPhone_number(userRequestDto.getPhoneNumber());

        userRepository.save(user);
        String token = jwtService.generateToken(user.getUsername(), user.getRole().name(),user.getStatus().name());
        return new AuthResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFull_name(),
                user.getPhone_number(),
                user.getRole().name(),
                user.getStatus().name(),
                user.getCreated_at(),
                token
        );
    }

    @Override
    public AuthResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        Users user = userRepository.findByUsername(userLoginRequestDto.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username"));

        if (!passwordEncoder.matches(userLoginRequestDto.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
        }
            String token = jwtService.generateToken(user.getUsername(), user.getRole().name(),user.getStatus().name());
        return new AuthResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFull_name(),
                user.getPhone_number(),
                user.getRole().name(),
                user.getStatus().name(),
                user.getCreated_at(),
                token
        );
    }

    @Override
    public List<AuthResponseDto> getAllAccounts() {
       List<Users> users= userRepository.findAll();
       List<AuthResponseDto>authResponseDtos = new java.util.ArrayList<>(List.of());
        for(Users users1 : users)
        {
            authResponseDtos.add(userMapper.userToDto(users1));
        }
        return authResponseDtos;
    }
}
