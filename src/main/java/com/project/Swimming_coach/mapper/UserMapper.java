package com.project.Swimming_coach.mapper;

import com.project.Swimming_coach.model.dto.AuthResponseDto;
import com.project.Swimming_coach.model.entity.Users;
import com.project.Swimming_coach.model.enums.Role;
import com.project.Swimming_coach.model.enums.Status;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public AuthResponseDto userToDto(Users users)
    {
        AuthResponseDto dto = new AuthResponseDto();

        dto.setId(users.getId());
        dto.setUsername(users.getUsername());
        dto.setEmail(users.getEmail());
        dto.setFullName(users.getFull_name());
        dto.setPhoneNumber(users.getPhone_number());

        if (users.getRole() != null) {
            dto.setRole(users.getRole().name()); // Convert Enum to String
        }

        if (users.getStatus() != null) {
            dto.setStatus(users.getStatus().name()); // Convert Enum to String
        }

        dto.setCreatedAt(users.getCreated_at());

        return dto;
    }
    public Users usersToEntity(AuthResponseDto dto)
    {
        Users user = new Users();

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
