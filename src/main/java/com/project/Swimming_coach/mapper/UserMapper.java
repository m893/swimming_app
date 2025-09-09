package com.project.Swimming_coach.mapper;

import com.project.Swimming_coach.model.dto.AuthResponseDto;
import com.project.Swimming_coach.model.entity.User;
import com.project.Swimming_coach.model.enums.Role;
import com.project.Swimming_coach.model.enums.Status;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public AuthResponseDto userToDto(User user)
    {
        AuthResponseDto dto = new AuthResponseDto();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFull_name());
        dto.setPhoneNumber(user.getPhone_number());

        if (user.getRole() != null) {
            dto.setRole(user.getRole().name()); // Convert Enum to String
        }

        if (user.getStatus() != null) {
            dto.setStatus(user.getStatus().name()); // Convert Enum to String
        }

        dto.setCreatedAt(user.getCreated_at());

        return dto;
    }
    public User usersToEntity(AuthResponseDto dto)
    {
        User user = new User();

        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setFull_name(dto.getFullName());
        user.setPhone_number(dto.getPhoneNumber());

        if (dto.getRole() != null) {
            user.setRole(Role.valueOf(dto.getRole().toUpperCase()));
        }

        if (dto.getStatus() != null) {
            user.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        }

        user.setCreated_at(dto.getCreatedAt());

        return user;
    }

}
