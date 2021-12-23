package ru.geekbrains.homework12.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework12.dto.RoleDto;
import ru.geekbrains.homework12.dto.UserDto;
import ru.geekbrains.homework12.dto.UserDtoSuperAdmin;
import ru.geekbrains.homework12.entities.User;
import ru.geekbrains.homework12.exceptions.ResourceNotFoundException;
import ru.geekbrains.homework12.services.RoleService;
import ru.geekbrains.homework12.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles/v1")
@Slf4j
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<RoleDto> index(){
        return roleService.findAll().stream().map(RoleDto::new).collect(Collectors.toList());
    }
}
