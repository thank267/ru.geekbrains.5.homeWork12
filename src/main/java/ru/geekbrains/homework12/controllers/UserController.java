package ru.geekbrains.homework12.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework12.dto.UserDto;
import ru.geekbrains.homework12.dto.UserDtoSuperAdmin;
import ru.geekbrains.homework12.entities.User;
import ru.geekbrains.homework12.exceptions.ResourceNotFoundException;
import ru.geekbrains.homework12.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/v1")
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> index(){
        return userService.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public UserDto delete(@PathVariable("id") long id) {
        return userService.deleteById(id).map(UserDto::new)
                .orElseThrow(() -> new ResourceNotFoundException("Unable delete User by id: "+ id ));

    }

    @PostMapping( consumes = "application/json", produces = "application/json")
    public UserDtoSuperAdmin save(@RequestBody UserDtoSuperAdmin userDto) {
        userDto.setId(null);
        return new UserDtoSuperAdmin(userService.save(new User(userDto)));
    }

    @PutMapping(value= "/updateRole",consumes = "application/json", produces = "application/json")
    public UserDtoSuperAdmin updateRole(@RequestBody UserDtoSuperAdmin userDto) {
        return new UserDtoSuperAdmin(userService.updateRole(new User(userDto)));

    }

}
